package com.ceostocks.services.jms;

import static com.ceostocks.services.jms.MessageConstant.EMAIL_ID;
import static com.ceostocks.services.jms.MessageConstant.FIRST_NAME;
import static com.ceostocks.services.jms.MessageConstant.LAST_NAME;
import static com.ceostocks.services.jms.MessageConstant.SUBJECT;
import static com.ceostocks.services.jms.MessageConstant.TEMPLATE_NAME;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.ceostocks.common.util.EmailUtility;

/**
 * 
 * @author Arun
 *
 */
public class EmailConsumer implements MessageListener {

	@Override
	public void onMessage(Message paramMessage) {
		try {
			MapMessage mm = (MapMessage) paramMessage;
			if (mm.getString(EMAIL_ID.name()) == null)
				throw new Exception("e-mail id null.");
			List<String> recipients = Arrays.asList(mm.getString(MessageConstant.EMAIL_ID.name()));

			if (mm.getString(SUBJECT.name()) == null)
				throw new Exception("subject null.");
			String subject = mm.getString(MessageConstant.SUBJECT.name());

			if (mm.getString(TEMPLATE_NAME.name()) == null)
				throw new Exception("e-mail templateName null.");
			String templateName = mm.getString(MessageConstant.SUBJECT.name());

			Map<String, Object> holderMap = new HashMap<String, Object>();
			holderMap.put(FIRST_NAME.name(), mm.getString(FIRST_NAME.name()));
			holderMap.put(LAST_NAME.name(), mm.getString(LAST_NAME.name()));

			EmailUtility.postMailType2("01", recipients, null, null, subject, templateName, holderMap, 1);
			System.out.println(paramMessage);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Hi");
		}
	}
}
