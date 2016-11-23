package com.app.scheduler.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.commonexception.BaseException;
import com.app.scheduler.manager.SchedulerManager;
import com.app.task.service.SchedulerService;

@Service
public class EmailSchedulerService implements SchedulerService {

	@Autowired
	private SchedulerManager schedulerManager;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public synchronized boolean sendEmailWhenNewCreated() throws BaseException {
		try {
			schedulerManager.sendEmailWhenNewCreated();
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public synchronized boolean sendEmailDailyDigest() throws BaseException {
		try {
			schedulerManager.sendDealNeighborhood();
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		schedulerManager.manageTask();
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Async
	public boolean postSocialPosts() throws BaseException {

		try {
			schedulerManager.postSocialPosts();
			schedulerManager.doPostOnGcdPages();
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
