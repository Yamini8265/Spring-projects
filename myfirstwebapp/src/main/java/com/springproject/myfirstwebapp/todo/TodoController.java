package com.springproject.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes(value = "name")
public class TodoController {
	
	
	@Autowired
	private TodoService todoService;

	@RequestMapping("list-todos")
	public String listTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUserName("YaminiNamburi");
		model.addAttribute("todos",todos);
		return "todoList";
		
	}
	
	@RequestMapping(value = "add-todos",method=RequestMethod.GET)
	public String showNewTodosPage(ModelMap model) {
		String username = (String) model.get("name");
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo",todo);
		return "todo";
	}
	
		
	@RequestMapping(value ="add-todos",method=RequestMethod.POST)
	public String addTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		String username = (String) model.get("name");

		todoService.addToTodoList(username,todo.getDescription(),todo.getTargetdate(),false);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoService.deleteById(id);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.POST)
	public String UpdateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	
	
}
