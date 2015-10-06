package com.ceostocks.model.social.post;

import com.ceostocks.common.base.Base_;
import com.ceostocks.model.social.post.Likes.LikesPK;
import com.ceostocks.model.user.UserMaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-16T20:54:21.555+0530")
@StaticMetamodel(Likes.class)
public class Likes_ extends Base_ {
	public static volatile SingularAttribute<Likes, LikesPK> likesPK;

	@StaticMetamodel(LikesPK.class)
	public static class LikesPK_ {
		public static volatile SingularAttribute<LikesPK, UserMaster> userMaster;
		public static volatile SingularAttribute<LikesPK, TimelinePost> timelinePost;
	}
}
