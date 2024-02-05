package com.manojskillhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manojskillhub.payload.TaskDto;
import com.manojskillhub.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	//save all the task
	@PostMapping("/{userid}/tasks")
	public ResponseEntity<TaskDto> saveTask(@PathVariable(name="userid") long userid, @RequestBody TaskDto taskDto ){
		
		
		return new ResponseEntity<>(taskService.saveTask(userid, taskDto),HttpStatus.CREATED);
		
	}
	//get all task
	
@GetMapping("/{userid}/tasks")	
public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable(name="userid") long userid ){
	return new ResponseEntity<>(taskService.getAllTasks(userid),HttpStatus.OK);
		
	}
	
	//get indv task
	
	//delete indv task

}

