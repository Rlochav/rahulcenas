package com.app.model.task;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-04-05T15:13:47.534+0530")
@StaticMetamodel(GcdScheduledTask.class)
public class GcdScheduledTask_ {
	public static volatile SingularAttribute<GcdScheduledTask, Integer> taskId;
	public static volatile SingularAttribute<GcdScheduledTask, String> taskName;
	public static volatile SingularAttribute<GcdScheduledTask, Date> scheduledTime;
	public static volatile SingularAttribute<GcdScheduledTask, String> executionTime;
	public static volatile SingularAttribute<GcdScheduledTask, Integer> status;
}
