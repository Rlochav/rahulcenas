package com.ceostocks.model.social.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "GroupsUserLink.findAllJoindGroups()", query = "select gul from GroupsUserLink gul where gul.groupsUserLinkPK.userIndex=:userIndex") })
@Table(name = "GROUPS_USER_LINK")
public class GroupsUserLink implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6843195785897212915L;

	@EmbeddedId
	private GroupsUserLinkPK groupsUserLinkPK;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "JOINED_DATE")
	private Date joinedDate;

	public GroupsUserLink() {
		// orm use
	}

	/**
	 * @param groupsUserLinkPK
	 * @param joinedDate
	 */
	public GroupsUserLink(GroupsUserLinkPK groupsUserLinkPK, Date joinedDate) {
		this.groupsUserLinkPK = groupsUserLinkPK;
		this.joinedDate = joinedDate;
	}

	/**
	 * @return the groupsUserLinkPK
	 */
	public GroupsUserLinkPK getGroupsUserLinkPK() {
		return groupsUserLinkPK;
	}

	/**
	 * @return the joinedDate
	 */
	public Date getJoinedDate() {
		return joinedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupsUserLinkPK == null) ? 0 : groupsUserLinkPK.hashCode());
		result = prime * result + ((joinedDate == null) ? 0 : joinedDate.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupsUserLink other = (GroupsUserLink) obj;
		if (groupsUserLinkPK == null) {
			if (other.groupsUserLinkPK != null)
				return false;
		} else if (!groupsUserLinkPK.equals(other.groupsUserLinkPK))
			return false;
		if (joinedDate == null) {
			if (other.joinedDate != null)
				return false;
		} else if (!joinedDate.equals(other.joinedDate))
			return false;
		return true;
	}

}
