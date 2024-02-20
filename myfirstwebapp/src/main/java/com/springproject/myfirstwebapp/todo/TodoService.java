package com.springproject.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int id=0;
	
	static {
		todos.add(new Todo(++id,"Yamini","Learn Java",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++id,"Yamini","Learn Spring",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++id,"Yamini","Learn DSA",LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUserName(String username){
		System.out.println("Username="+username);
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		System.out.println(todos.stream().filter(predicate).toList());
		return todos.stream().filter(predicate).toList();
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
