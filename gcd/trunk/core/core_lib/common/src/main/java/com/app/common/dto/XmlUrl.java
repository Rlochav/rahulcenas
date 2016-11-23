package com.app.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.login.dto.UserInfo;
import com.app.utility.common.DateUtil;

@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "url")
public class XmlUrl {
	public enum ChangeFrequency {
		ALWAYS("always"), HOURLY("hourly"), DAILY("daily"), WEEKLY("weekly"), MONTHLY("monthly"), YEARLY("yearly"), NEVER("never");

		private String value;

		ChangeFrequency(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum Priority {
		HIGH("1.0"), MEDIUM("0.5"), LOW("0.3");

		private String value;

		Priority(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	@XmlElement
	private String loc;

	@XmlElement
	private String lastmod = DateUtil.getDateTimeWithTimeZone();

	@XmlElement
	private String changefreq;

	@XmlElement
	private String priority;

	public XmlUrl() {
	}

	public XmlUrl(String loc, Priority priority, ChangeFrequency changeFrequency) {
		this.loc = loc;
		this.priority = priority.getValue();
		this.changefreq = changeFrequency.getValue();
	}

	public String getLoc() {
		return loc;
	}

	public String getPriority() {
		return priority;
	}

	public String getChangefreq() {
		return changefreq;
	}

	public String getLastmod() {
		return lastmod;
	}
}