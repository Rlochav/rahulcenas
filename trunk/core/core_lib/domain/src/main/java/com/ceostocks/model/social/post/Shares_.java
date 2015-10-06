package com.ceostocks.model.social.post;

import com.ceostocks.common.base.Base_;
import com.ceostocks.model.social.post.Shares.SharesPK;
import com.ceostocks.model.user.UserMaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-16T20:59:14.417+0530")
@StaticMetamodel(Shares.class)
public class Shares_ extends Base_ {
	public static volatile SingularAttribute<Shares, SharesPK> sharesPK;

	@StaticMetamodel(SharesPK.class)
	public static class SharesPK_ {
		public static volatile SingularAttribute<SharesPK, UserMaster> userMaster;
		public static volatile SingularAttribute<SharesPK, TimelinePost> timelinePost;
	}
}
