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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@AttributeOverrides({ @AttributeOverride(name = "createdBy", column = @Column(name = "COMMENTED_BY")) })
@Table(name = "COMMENT")
public class Comment extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6054694410746409244L;
	@Id
	@GeneratedValue(generator = "sq_comment_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_comment_id", sequenceName = "SQ_COMMENT_ID", allocationSize = 1)
	@Column(name = "COMMENT_ID")
	private BigDecimal commentId;
	@Column(name = "COMMENT")
	private String commentText;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID")
	private TimelinePost timelinePost;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments = new HashSet<Comment>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_COMMENT_ID", nullable = true)
	private Comment comment;

	public Comment() {
		// orm use
	}

	/**
	 * @param commentId
	 * @param commentText
	 * @param timelinePost
	 * @param comments
	 * @param comment
	 */
	public Comment(String commentText, TimelinePost timelinePost) {
		super();
		this.commentText = commentText;
		this.timelinePost = timelinePost;
	}

	/**
	 * @return the commentText
	 */
	public String getCommentText() {
		return commentText;
	}

	/**
	 * @param commentText
	 *            the commentText to set
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
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

	/**
	 * @return the comments
	 */
	public Set<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * Adding comment into {@link List<Comment>}
	 * 
	 * @param comment
	 */
	public void addComment(Comment comment) {
		comments.add(comment);
	}

	/**
	 * @return the comment
	 */
	public Comment getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
	 * @return the commentId
	 */
	public BigDecimal getCommentId() {
		return commentId;
	}

}
