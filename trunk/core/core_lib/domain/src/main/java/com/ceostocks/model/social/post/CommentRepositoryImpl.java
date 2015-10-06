package com.ceostocks.model.social.post;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class CommentRepositoryImpl extends BaseDaoJpa<Comment, BigDecimal> implements CommentRepository {

	public CommentRepositoryImpl() {
		super(Comment.class);
	}

}
