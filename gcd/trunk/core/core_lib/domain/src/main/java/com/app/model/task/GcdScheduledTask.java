package com.app.model.task;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gcd_scheduled_task")
public class GcdScheduledTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4214491751289465484L;
	@Id
	@Column(name = "TaskId")
	private Integer taskId;
	@Column(name = "TaskName")
	private String taskName;
	@Column(name = "ScheduledTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduledTime;
	@Column(name = "executionTime")
	private String executionTime;
	@Column(name = "status")
	private Integer status;

	/**
	 * @return the taskId
	 */
	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName
	 *            the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the scheduledTime
	 */
	public Date getScheduledTime() {
		return scheduledTime;
	}

	/**
	 * @param scheduledTime
	 *            the scheduledTime to set
	 */
	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	/**
	 * @return the executionTime
	 */
	public String getExecutionTime() {
		return executionTime;
	}

	/**
	 * @param executionTime
	 *            the executionTime to set
	 */
	public void setExecutionTime(String executionTime) {
		this.executionTime = executionTime;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
