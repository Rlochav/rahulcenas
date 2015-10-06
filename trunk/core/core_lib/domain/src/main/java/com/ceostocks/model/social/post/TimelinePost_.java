package com.ceostocks.model.social.post;

import com.ceostocks.common.base.Base_;
import com.ceostocks.model.document.Document;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-10-02T22:23:31.256+0530")
@StaticMetamodel(TimelinePost.class)
public class TimelinePost_ extends Base_ {
	public static volatile SingularAttribute<TimelinePost, BigDecimal> postId;
	public static volatile SingularAttribute<TimelinePost, String> post;
	public static volatile SingularAttribute<TimelinePost, Integer> visibility;
	public static volatile SingularAttribute<TimelinePost, Integer> status;
	public static volatile SingularAttribute<TimelinePost, String> timeLineId;
	public static volatile SetAttribute<TimelinePost, Document> documents;
	public static volatile SetAttribute<TimelinePost, Comment> comments;
}
