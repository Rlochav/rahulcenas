package com.app.model.task;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-16T23:48:43.490+0530")
@StaticMetamodel(TaskInfo.class)
public class TaskInfo_ {
	public static volatile SingularAttribute<TaskInfo, Integer> taskId;
	public static volatile SingularAttribute<TaskInfo, String> taskName;
	public static volatile SingularAttribute<TaskInfo, String> delay;
	public static volatile SingularAttribute<TaskInfo, Integer> status;
}
