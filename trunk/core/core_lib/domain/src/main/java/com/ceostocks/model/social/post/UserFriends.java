package com.ceostocks.model.social.post;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "USER_FRIENDS")
public class UserFriends extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3718286889227837272L;

	@EmbeddedId
	private UserFriendsPK userFriendsPK;
	@Column(name = "IS_REQUEST_ACCEPTED", nullable = false)
	private Boolean isRequestAccepted;

	public UserFriends() {
		// orm use
	}

	/**
	 * @param userFriendsPK
	 * @param isRequestAccepted
	 */
	public UserFriends(UserFriendsPK userFriendsPK, Boolean isRequestAccepted) {
		super();
		this.userFriendsPK = userFriendsPK;
		this.isRequestAccepted = isRequestAccepted;
	}

	/**
	 * @return the isRequestAccepted
	 */
	public Boolean getIsRequestAccepted() {
		return isRequestAccepted;
	}

	/**
	 * @param isRequestAccepted
	 *            the isRequestAccepted to set
	 */
	public void setIsRequestAccepted(Boolean isRequestAccepted) {
		this.isRequestAccepted = isRequestAccepted;
	}

	/**
	 * @return the userFriendsPK
	 */
	public UserFriendsPK getUserFriendsPK() {
		return userFriendsPK;
	}

}
