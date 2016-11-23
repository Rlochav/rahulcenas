package com.app.scheduler.subscription;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.task.service.SchedulerService;

public class DailyDigestScheduler {

	@Autowired
	private SchedulerService schedulerService;

	@Scheduled(cron = "*/86400 * * * * ?")
	public void scheduleTask() throws ParseException {
		try {
			if (schedulerService != null) {
				schedulerService.sendEmailDailyDigest();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
