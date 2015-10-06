package com.ceostocks.model.document;

import java.math.BigDecimal;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class DocumentRepositoryImpl extends BaseDaoJpa<Document, BigDecimal> implements DocumentRepository {

	public DocumentRepositoryImpl() {
		super(Document.class);
	}

	@Override
	public Document getByFileSavedAs(String fileSavedAs) {
		TypedQuery<Document> typedQuery = getEntityManager().createNamedQuery("Document.findByFileSavedAs", Document.class);
		typedQuery.setParameter("fileSavedAs", fileSavedAs);
		return typedQuery.getSingleResult();
	}
}
