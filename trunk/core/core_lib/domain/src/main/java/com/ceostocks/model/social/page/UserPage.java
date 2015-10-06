package com.ceostocks.model.social.page;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;
import com.ceostocks.model.social.post.TimelinePost;
import com.ceostocks.model.user.UserMaster;

@Entity
@Table(name = "USER_PAGE")
public class UserPage extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5582762830189239694L;
	@Id
	@GeneratedValue(generator = "sq_user_page_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_user_page_id", sequenceName = "SQ_USER_PAGE_ID", allocationSize = 1)
	@Column(name = "ID")
	private BigDecimal id;
	@Column(name = "TITLE")
	private String title;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OWNER")
	private UserMaster userMaster;

	/*
	 * //@OneToMany(mappedBy = "userPage", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY, orphanRemoval = true) private Set<TimelinePost>
	 * timelinePosts = new HashSet<TimelinePost>();
	 */

	public UserPage() {

	}

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the timelinePosts
	 */
	/*
	 * public Set<TimelinePost> getTimelinePosts() { return timelinePosts; }
	 *//**
	 * @param timelinePosts
	 *            the timelinePosts to set
	 */
	/*
	 * public void setTimelinePosts(Set<TimelinePost> timelinePosts) {
	 * this.timelinePosts = timelinePosts; }
	 */

}
