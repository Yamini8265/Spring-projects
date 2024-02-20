package com.springproject.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	@Size(min = 10,message="Enter atleast 10 characters")
	private String description;
	private LocalDate targetdate;
	private boolean isDone;
	private String username;

	
	
	public Todo() {

	}

	public Todo(int id,String username, String description, LocalDate targetdate, boolean isDone) {
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetdate = targetdate;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetdate() {
		return targetdate;
	}

	public void setTargetdate(LocalDate targetdate) {
		this.targetdate = targetdate;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", targetdate=" + targetdate + ", isDone=" + isDone
				+ ", username=" + username + "]";
	}





}
