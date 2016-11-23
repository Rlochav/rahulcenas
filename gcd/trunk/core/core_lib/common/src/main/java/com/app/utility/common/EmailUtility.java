package com.app.utility.common;

import static com.app.utility.common.AppPropertyBuilder.getProperty;

import java.io.File;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class EmailUtility {

	/**
	 * This method is used to send the mail by using velocity templates. Enh#
	 * 12199 Starts
	 * 
	 * @param recipients
	 * @param recipientsCC
	 * @param subject
	 * @param templatePath
	 * @param holderMap
	 * @return
	 */

	public static boolean postMailType2(String dbId, List<String> recipients, List<String> recipientsCC, List<String> recipientsBCC, String subject,
			String templateName, Map<String, Object> holderMap, Integer type) throws Exception {
		String message = parseVelocityMessage(dbId, templateName, holderMap, type);

		if (getProperty("email.trigger.switch", "01").equals("Y")) {
			return postMailType1(dbId, recipients, recipientsCC, recipientsBCC, subject, message, type);
		}
		// return postMailType1(dbId, recipients, recipientsCC, recipientsBCC,
		// subject, message, type);
		return true;
	}

	private static String parseVelocityMessage(String dbId, String templateName, Map<String, Object> holderMap, Integer type) throws ResourceNotFoundException,
			ParseErrorException, Exception {

		StringWriter w = new StringWriter();
		VelocityEngine ve = new VelocityEngine();

		Properties props = setEmailProperty(dbId, type);
		props.setProperty(
				"file.resource.loader.path",
				AppPropertyBuilder.getAppConfigFolder() + File.separator + dbId + File.separator
						+ AppPropertyBuilder.getProperty("mail.eMailTemplatesFolder", dbId));
		props.setProperty("resource.loader", "file");
		ve.init(props);

		Template template = ve.getTemplate(templateName);

		VelocityContext context = new VelocityContext();
		for (String key : holderMap.keySet())
			context.put(key, holderMap.get(key));

		template.merge(context, w);

		return w.toString();
	}

	/**
	 * 
	 * @param recipients
	 * @param recipientsCC
	 * @param subject
	 * @param message
	 * @param type
	 * @return
	 */
	public static boolean postMailType1(String dbId, List<String> recipients, List<String> recipientsCC, List<String> recipientsBCC, String subject,
			String message, Integer type) throws Exception {
		if (Boolean.parseBoolean(AppPropertyBuilder.getProperty("enableMail", dbId))) {
			Properties props = setEmailProperty(dbId, type);
			String from = AppPropertyBuilder.getProperty("mail.from" + type, dbId);

			// for authenticating user
			Authenticator auth = new SMTPAuthenticator(dbId, type);
			// Get the default Session object.
			Session session1 = Session.getInstance(props, auth);
			// Define message
			Message mailmessage = new MimeMessage(session1);
			// set message from
			mailmessage.setFrom(new InternetAddress(from));
			/* add TO recipients */
			InternetAddress[] addressTo = new InternetAddress[recipients.size()];
			int i = 0;
			for (String recipient : recipients) {
				addressTo[i] = new InternetAddress(recipient);
				i++;
			}
			mailmessage.setRecipients(Message.RecipientType.TO, addressTo);

			if (recipientsCC != null && recipientsCC.size() > 0) {
				InternetAddress[] addressCC = null;
				int j = 0;
				for (String recipientCC : recipientsCC) {
					if (!recipientCC.trim().isEmpty()) {
						if (addressCC == null)
							addressCC = new InternetAddress[recipientsCC.size()];
						addressCC[j] = new InternetAddress(recipientCC);
						j++;
					}
				}
				if (addressCC != null)
					mailmessage.setRecipients(Message.RecipientType.CC, addressCC);
			}

			if (recipientsBCC != null && recipientsBCC.size() > 0) {
				InternetAddress[] addressBCC = null;
				int j = 0;
				for (String recipientBCC : recipientsBCC) {
					if (!recipientBCC.trim().isEmpty()) {
						if (addressBCC == null)
							addressBCC = new InternetAddress[recipientsBCC.size()];
						addressBCC[j] = new InternetAddress(recipientBCC);
						j++;
					}
				}
				if (addressBCC != null)
					mailmessage.setRecipients(Message.RecipientType.BCC, addressBCC);
			}

			/* add subject */
			if (subject != null)
				mailmessage.setSubject(subject);

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message

			messageBodyPart.setContent(message, "text/html");
			// messageBodyPart.setText(MessageText + "\n\n");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			mailmessage.setContent(multipart);
			// Send the message
			Transport.send(mailmessage);
			System.out.println("Sent message successfully....");

		}
		return true;
	}

	private static Properties setEmailProperty(String dbId, Integer type) {
		// Get system properties
		Properties props = System.getProperties();
		// Setup mail server
		props.put("mail.tranport.protocol", "smtp");

		props.put("mail.smtp.host", AppPropertyBuilder.getProperty("mail.smtp.host", dbId));
		props.put("mail.smtp.port", AppPropertyBuilder.getProperty("mail.smtp.port", dbId));
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.setProperty("mail.user", AppPropertyBuilder.getProperty("mail.smtp.user" + type, dbId));
		props.setProperty("mail.password", AppPropertyBuilder.getProperty("mail.smtp.password", dbId));
		return props;
	}

}

class SMTPAuthenticator extends javax.mail.Authenticator {
	public PasswordAuthentication authentication;

	@SuppressWarnings("unused")
	private SMTPAuthenticator() {
	}

	SMTPAuthenticator(String dbId, Integer type) {
		authentication = new PasswordAuthentication(AppPropertyBuilder.getProperty("mail.smtp.user" + type, dbId), AppPropertyBuilder.getProperty(
				"mail.smtp.password", dbId));
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
}