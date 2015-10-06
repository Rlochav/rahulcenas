package com.ceostocks.model.social.post;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;
import com.ceostocks.model.user.UserMaster;

@Entity
@Table(name = "LIKES")
public class Likes extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4516667790157988184L;
	@EmbeddedId
	private LikesPK likesPK;

	public Likes() {
		// orm use
	}

	/**
	 * @return the likesPK
	 */
	public LikesPK getLikesPK() {
		return likesPK;
	}

	/**
	 * @param likesPK
	 *            the likesPK to set
	 */
	public void setLikesPK(LikesPK likesPK) {
		this.likesPK = likesPK;
	}

	@Embeddable
	public class LikesPK implements Serializable {

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "USER_INDEX")
		private UserMaster userMaster;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "POST_ID")
		private TimelinePost timelinePost;

		public LikesPK() {

		}

		/**
		 * @return the userMaster
		 */
		public UserMaster getUserMaster() {
			return userMaster;
		}

		/**
		 * @param userMaster
		 *            the userMaster to set
		 */
		public void setUserMaster(UserMaster userMaster) {
			this.userMaster = userMaster;
		}

		/**
		 * @return the timelinePost
		 */
		public TimelinePost getTimelinePost() {
			return timelinePost;
		}

		/**
		 * @param timelinePost
		 *            the timelinePost to set
		 */
		public void setTimelinePost(TimelinePost timelinePost) {
			this.timelinePost = timelinePost;
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
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((timelinePost == null) ? 0 : timelinePost.hashCode());
			result = prime * result + ((userMaster == null) ? 0 : userMaster.hashCode());
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
			LikesPK other = (LikesPK) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (timelinePost == null) {
				if (other.timelinePost != null)
					return false;
			} else if (!timelinePost.equals(other.timelinePost))
				return false;
			if (userMaster == null) {
				if (other.userMaster != null)
					return false;
			} else if (!userMaster.equals(other.userMaster))
				return false;
			return true;
		}

		private Likes getOuterType() {
			return Likes.this;
		}

	}
}
