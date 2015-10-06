package com.ceostocks.model.social.post;

import com.ceostocks.common.base.Base_;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-16T14:08:25.180+0530")
@StaticMetamodel(Comment.class)
public class Comment_ extends Base_ {
	public static volatile SingularAttribute<Comment, BigDecimal> commentId;
	public static volatile SingularAttribute<Comment, String> commentText;
	public static volatile SingularAttribute<Comment, TimelinePost> timelinePost;
	public static volatile SetAttribute<Comment, Comment> comments;
	public static volatile SingularAttribute<Comment, Comment> comment;
}
