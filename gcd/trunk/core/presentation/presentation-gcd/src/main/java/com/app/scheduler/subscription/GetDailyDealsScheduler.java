package com.app.scheduler.subscription;

import static com.app.utility.common.AppPropertyBuilder.getProperty;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.task.service.SchedulerService;

public class GetDailyDealsScheduler {

	@Autowired
	private SchedulerService schedulerService;

	@Scheduled(cron = "*/59 * * * * ?")
	public synchronized void scheduleTask() throws ParseException {
		try {
			if (schedulerService != null) {
				if ("Y".equals(getProperty("gcd.scheduler.hook", "01"))) {
					schedulerService.sendEmailWhenNewCreated();
					schedulerService.postSocialPosts();
					schedulerService.sendEmailDailyDigest();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
