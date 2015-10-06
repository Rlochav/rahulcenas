package com.ceostocks.services.ncounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceostocks.model.ncounter.NCounter;
import com.ceostocks.model.ncounter.NCounterRepository;

@Repository
public class NCounterServicesImpl implements NCounterServices {

	@Autowired
	private NCounterRepository nCounterRepository;

	@Override
	public String getNextKey(String keyName) {
		NCounter nCounter = nCounterRepository.findById(keyName);
		if (nCounter == null) {
			nCounter = new NCounter();
			nCounter.setKeyName(keyName);
			nCounter.setStartNo(1);
			nCounter.setNextNo(1);
		}
		Integer nextKey = nCounter.getNextNo();
		nCounter.setNextNo(nextKey + 1);
		nCounterRepository.save(nCounter);
		return nextKey.toString();
	}
}
