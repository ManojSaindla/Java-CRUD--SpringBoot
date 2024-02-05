package com.manojskillhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manojskillhub.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findAllByUsersId(long userid);

}
