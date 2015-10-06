package com.ceostocks.model.ncounter;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class NCounterRepositoryImpl extends BaseDaoJpa<NCounter, String> implements NCounterRepository {

	public NCounterRepositoryImpl() {
		super(NCounter.class);
	}
}
