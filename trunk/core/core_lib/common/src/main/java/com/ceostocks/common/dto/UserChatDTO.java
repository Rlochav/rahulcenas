package com.ceostocks.common.dto;

import java.io.Serializable;

public class UserChatDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3529711772850206001L;
	private String msgId;
	private String userFrom;
	private String userTo;
	private String msg;
	private String msgtime;
	private String nickName;

	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId
	 *            the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the userFrom
	 */
	public String getUserFrom() {
		return userFrom;
	}

	/**
	 * @param userFrom
	 *            the userFrom to set
	 */
	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}

	/**
	 * @return the userTo
	 */
	public String getUserTo() {
		return userTo;
	}

	/**
	 * @param userTo
	 *            the userTo to set
	 */
	public void setUserTo(String userTo) {
		this.userTo = userTo;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the msgtime
	 */
	public String getMsgtime() {
		return msgtime;
	}

	/**
	 * @param msgtime
	 *            the msgtime to set
	 */
	public void setMsgtime(String msgtime) {
		this.msgtime = msgtime;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
