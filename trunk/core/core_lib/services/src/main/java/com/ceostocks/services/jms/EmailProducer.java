package com.ceostocks.services.jms;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 
 * @author Arun
 *
 */
public class EmailProducer {
	//@Autowired
	JmsTemplate jmsTemplate;

	private void sendEmail(final Map<String, String> emailContentMap) {
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				MapMessage mapMessage = session.createMapMessage();
				for (String key : emailContentMap.keySet()) {
					mapMessage.setString(key, emailContentMap.get(key));
				}
				return mapMessage;
			}
		});
	}

	public Boolean notify(Map<String, String> emailContentMap) {
		try {
			sendEmail(emailContentMap);
		} catch (JmsException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
