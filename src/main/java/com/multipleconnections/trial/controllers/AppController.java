package com.multipleconnections.trial.controllers;

import com.multipleconnections.trial.models.Comment;
import com.multipleconnections.trial.models.Person;
import com.multipleconnections.trial.models.Task;
import com.multipleconnections.trial.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    private AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/")
    public String everything(Model model) {
        model.addAttribute("people", appService.listPeople());
        model.addAttribute("tasks", appService.listTasks());
        model.addAttribute("comments", appService.listComments());
        return "index";
    }

    @GetMapping("/people")
    public String listPeople(Model model, @ModelAttribute("newPerson") Person person) {
        model.addAttribute("people", appService.listPeople());
        return "people";
    }

    @PostMapping("/people/add")
    public String addPerson(@ModelAttribute("newPerson") Person person) {
        appService.savePerson(person);
        return "redirect:/people";
    }

    @GetMapping("/people/{personId}/tasks")
    public String listTasks(@PathVariable Long personId, Model model, @ModelAttribute("newTask") Task task) {
        model.addAttribute("person", appService.findPerson(personId));
        model.addAttribute("tasks", appService.listTasksByPerson(personId));
        return "tasks";
    }

    @PostMapping("/people/{personId}/tasks/add")
    public String addTask(@PathVariable Long personId, @ModelAttribute("newTask") Task task) {
        appService.saveTask(personId, task);
        return "redirect:/people/" + personId + "/tasks";
    }

    @GetMapping("/people/{personId}/tasks/{taskId}/comments")
    public String addComment(@PathVariable Long personId, @PathVariable Long taskId, @ModelAttribute("newComment") Comment comment, Model model) {
        model.addAttribute("person", appService.findPerson(personId));
        model.addAttribute("task", appService.findTask(taskId));
        model.addAttribute("comments", appService.listCommentsByTaskId(taskId));
        model.addAttribute("newComment", comment);
        return "comments";
    }

    @PostMapping("/people/{personId}/tasks/{taskId}/comments/add")
    public String saveComment(@PathVariable Long personId, @PathVariable Long taskId, @ModelAttribute("newComment") Comment comment) {
        appService.saveComment(personId, taskId, comment);
        return "redirect:/people/" + personId + "/tasks/" + taskId + "/comments";
    }
}
