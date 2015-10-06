package com.ceostocks.model.document;

import com.ceostocks.common.base.Base_;
import com.ceostocks.model.social.post.TimelinePost;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-12T10:45:16.363+0530")
@StaticMetamodel(Document.class)
public class Document_ extends Base_ {
	public static volatile SingularAttribute<Document, BigDecimal> id;
	public static volatile SingularAttribute<Document, String> originalFileName;
	public static volatile SingularAttribute<Document, String> fileSavedAs;
	public static volatile SingularAttribute<Document, String> fileSavedAsThumbnail;
	public static volatile SingularAttribute<Document, Integer> status;
	public static volatile SingularAttribute<Document, String> contentType;
	public static volatile SingularAttribute<Document, String> fileSize;
	public static volatile SingularAttribute<Document, Integer> fileType;
	public static volatile SingularAttribute<Document, String> fileLocation;
	public static volatile SingularAttribute<Document, TimelinePost> timelinePost;
}
