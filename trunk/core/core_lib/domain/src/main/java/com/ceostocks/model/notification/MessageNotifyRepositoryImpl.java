package com.ceostocks.model.notification;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class MessageNotifyRepositoryImpl extends BaseDaoJpa<MessageNotify, BigDecimal> implements MessageNotifyRepository {

	public MessageNotifyRepositoryImpl() {
		super(MessageNotify.class);
	}
}
