package com.ceostocks.model.lkupcode;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class LkupCodeRepositoryImpl extends BaseDaoJpa<LkupCode, LkupCodePk> implements LkupCodeRepository {

	public LkupCodeRepositoryImpl() {
		super(LkupCode.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<LkupCode> getAll() {
		TypedQuery<LkupCode> typedQuery = getEntityManager().createQuery("from " + LkupCode.class.getName(), LkupCode.class);

		return typedQuery.getResultList();
	}
}
