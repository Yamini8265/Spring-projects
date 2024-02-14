package com.springproject.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int id=0;
	
	static {
		todos.add(new Todo(++id,"YaminiNamburi","Learn Java",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++id,"YaminiNamburi","Learn Spring",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++id,"YaminiNamburi","Learn DSA",LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUserName(String username){
		return todos;
	}



	public void addToTodoList(String username, String description, LocalDate targetdate, boolean isDone) {
		Todo todo = new Todo(++id,username,description,targetdate,isDone);
		todos.add(todo);
	}



	public void deleteById(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
		
	}



	public Todo findById(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();	
		return todo;
	}



	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
		
	}

}
