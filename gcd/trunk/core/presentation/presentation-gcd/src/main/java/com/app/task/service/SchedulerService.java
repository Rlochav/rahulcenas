package com.app.task.service;

import com.app.commonexception.BaseException;

public interface SchedulerService {

	public boolean sendEmailWhenNewCreated() throws BaseException;

	public boolean sendEmailDailyDigest() throws BaseException;

	public boolean postSocialPosts() throws BaseException;
}
