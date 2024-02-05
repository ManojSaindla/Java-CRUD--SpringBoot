package com.manojskillhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name="taskname", nullable = false)
private String taskname;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="users_id")
private User user;

}
