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
import com.ceostocks.model.social.post.Likes.LikesPK;
import com.ceostocks.model.user.UserMaster;

@AttributeOverrides({ @AttributeOverride(name = "createdBy", column = @Column(name = "LIKED_BY")) })
@Entity
@Table(name = "SHARES")
public class Shares extends Base {

	@EmbeddedId
	private SharesPK sharesPK;

	public Shares() {
		// orm use
	}

	@Embeddable
	public class SharesPK implements Serializable {

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "USER_INDEX")
		private UserMaster userMaster;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "POST_ID")
		private TimelinePost timelinePost;

		public SharesPK() {

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
			SharesPK other = (SharesPK) obj;
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

		private Shares getOuterType() {
			return Shares.this;
		}

	}
}
