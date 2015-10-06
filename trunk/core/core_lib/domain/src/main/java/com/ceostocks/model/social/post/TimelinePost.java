package com.ceostocks.model.social.post;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;
import com.ceostocks.model.document.Document;

@NamedQueries({ @NamedQuery(name = "TimelinePost.findByTimelineId", query = "select t from TimelinePost t where t.timeLineId=:timeLineId order by t.createdDate DESC") })
@AttributeOverrides({ @AttributeOverride(name = "createdBy", column = @Column(name = "POSTED_BY")) })
@Entity
@Table(name = "TIMELINE_POST")
public class TimelinePost extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6467941616749284006L;

	@Id
	@GeneratedValue(generator = "sq_timeline_post_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_timeline_post_id", sequenceName = "SQ_TIMELINE_POST_ID", allocationSize = 1)
	@Column(name = "POST_ID")
	private BigDecimal postId;
	@Column(name = "POST")
	private String post;
	@Column(name = "VISIBILITY")
	private Integer visibility;
	@Column(name = "STATUS")
	private Integer status;
	@Column(name = "TIMELINE_ID")
	private String timeLineId;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "timelinePost", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Document> documents = new HashSet<Document>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "timelinePost", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("createdDate ASC")
	private Set<Comment> comments = new HashSet<Comment>();

	public TimelinePost() {
		// orm use
	}

	/**
	 * @param post
	 * @param visibility
	 * @param status
	 * @param timeLineId
	 */
	public TimelinePost(String post, Integer visibility, Integer status, String timeLineId) {
		super();
		this.post = post;
		this.visibility = visibility;
		this.status = status;
		this.timeLineId = timeLineId;
	}

	/**
	 * @return the postId
	 */
	public BigDecimal getPostId() {
		return postId;
	}

	/**
	 * @return the post
	 */
	public String getPost() {
		return post;
	}

	/**
	 * @return the visibility
	 */
	public Integer getVisibility() {
		return visibility;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @return the timeLineId
	 */
	public String getTimeLineId() {
		return timeLineId;
	}

	/**
	 * @return the documents
	 */
	public Set<Document> getDocuments() {
		return documents;
	}

	public void addDocument(Document document) {
		this.documents.add(document);
	}

	/**
	 * @return the comments
	 */
	public Set<Comment> getComments() {
		return comments;
	}

}
