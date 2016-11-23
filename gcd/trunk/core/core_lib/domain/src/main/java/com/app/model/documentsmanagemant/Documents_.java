package com.app.model.documentsmanagemant;

import com.app.model.base.BaseNoUDF_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-30T21:16:19.164+0530")
@StaticMetamodel(Documents.class)
public class Documents_ extends BaseNoUDF_ {
	public static volatile SingularAttribute<Documents, Integer> docId;
	public static volatile SingularAttribute<Documents, String> orignalFileName;
	public static volatile SingularAttribute<Documents, String> docExt;
	public static volatile SingularAttribute<Documents, String> docSize;
	public static volatile SingularAttribute<Documents, String> parentFolderPath;
	public static volatile SingularAttribute<Documents, String> fileSavedAs;
	public static volatile SingularAttribute<Documents, String> contentType;
	public static volatile SingularAttribute<Documents, String> documentTitle;
	public static volatile SingularAttribute<Documents, Integer> showOnPage;
}
