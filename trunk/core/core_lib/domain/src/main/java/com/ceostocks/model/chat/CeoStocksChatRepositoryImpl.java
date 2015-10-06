package com.ceostocks.model.chat;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class CeoStocksChatRepositoryImpl extends BaseDaoJpa<CeoStocksChat, Integer> implements CeoStocksChatRepository {

	public CeoStocksChatRepositoryImpl() {
		super(CeoStocksChat.class);
	}

	@Override
	public List<CeoStocksChat> getUserChat(String userFrom) {
		TypedQuery<CeoStocksChat> query = getEntityManager().createQuery("from CeoStocksChat c where c.userTo=:userTo and c.messageState=:messageState", CeoStocksChat.class);
		query.setParameter("userTo", userFrom);
		query.setParameter("messageState", "sent");
		return query.getResultList();
	}
}
