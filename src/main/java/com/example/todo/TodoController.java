package com.example.todo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class TodoController {

    private final TodoList todoList = new TodoList();

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("items", todoList.getItems());
        return "index";
    }

    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        List<Todo> items = todoList.getItems();
        items.add(todo);
        return "redirect:/";
    }
}
