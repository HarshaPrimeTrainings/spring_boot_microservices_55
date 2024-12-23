package org.learning;

import org.springframework.stereotype.Component;

@Component
public class ExternalClass {
	
	private int taskid;
	
	private String task;

	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	@Override
	public String toString() {
		return "ExternalClass [taskid=" + taskid + ", task=" + task + "]";
	}

}
