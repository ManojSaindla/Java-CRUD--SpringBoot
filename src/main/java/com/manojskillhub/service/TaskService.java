package com.manojskillhub.service;

import java.util.List;

import com.manojskillhub.payload.TaskDto;

public interface TaskService {
	
	public TaskDto saveTask(long userid, TaskDto taskDto);
	
	public List<TaskDto> getAllTasks(long userid);

}
