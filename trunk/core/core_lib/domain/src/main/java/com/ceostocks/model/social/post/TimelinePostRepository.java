package com.ceostocks.model.social.post;

import java.math.BigDecimal;
import java.util.List;

import com.ceostocks.common.base.BaseDao;
import com.ceostocks.common.dto.PostDTO;

public interface TimelinePostRepository extends BaseDao<TimelinePost, BigDecimal> {

	List<TimelinePost> getPostsByTimelineId(String timelineId, Integer start, Integer total);

}
