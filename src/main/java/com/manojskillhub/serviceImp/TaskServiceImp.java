package com.manojskillhub.serviceImp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manojskillhub.entity.Task;
import com.manojskillhub.entity.User;
import com.manojskillhub.exception.UserNotFound;
import com.manojskillhub.payload.TaskDto;
import com.manojskillhub.repository.TaskRepository;
import com.manojskillhub.repository.UserRepository;
import com.manojskillhub.service.TaskService;

@Service
public class TaskServiceImp implements TaskService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public TaskDto saveTask(long userid, TaskDto taskDto) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(userid).orElseThrow(() -> new UserNotFound(String.format("User Id %d not found", userid)));
		Task task =  modelMapper.map(taskDto, Task.class);
		task.setUser(user);
		Task savedTask = taskRepository.save(task);
		return modelMapper.map(savedTask, TaskDto.class);
	}

	@Override
	public List<TaskDto> getAllTasks(long userid) {
		// TODO Auto-generated method stub
		userRepository.findById(userid).orElseThrow(() -> new UserNotFound(String.format("User Id %d not found", userid)));

			List<Task> tasks= taskRepository.findAllByUsersId(userid);
		
		return tasks.stream().map(task -> modelMapper.map(task, TaskDto.class)).collect(Collectors.toList());
	}

}
