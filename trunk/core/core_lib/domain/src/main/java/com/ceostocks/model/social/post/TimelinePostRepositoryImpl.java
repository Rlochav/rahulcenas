package com.ceostocks.model.social.post;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;

import com.ceostocks.common.base.BaseDaoJpa;

public class TimelinePostRepositoryImpl extends BaseDaoJpa<TimelinePost, BigDecimal> implements TimelinePostRepository {

	public TimelinePostRepositoryImpl() {
		super(TimelinePost.class);
	}

	@Override
	public List<TimelinePost> getPostsByTimelineId(String timelineId, Integer start, Integer total) {
		TypedQuery<TimelinePost> typedQuery = getEntityManager().createNamedQuery("TimelinePost.findByTimelineId", TimelinePost.class);
		typedQuery.setParameter("timeLineId", timelineId);
		typedQuery.setFirstResult(start);
		typedQuery.setMaxResults(total);
		return typedQuery.getResultList();
	}

}
