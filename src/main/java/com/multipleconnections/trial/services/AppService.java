package com.multipleconnections.trial.services;

import com.multipleconnections.trial.models.Comment;
import com.multipleconnections.trial.models.Person;
import com.multipleconnections.trial.models.Task;
import com.multipleconnections.trial.repositories.CommentRepository;
import com.multipleconnections.trial.repositories.PersonRepository;
import com.multipleconnections.trial.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    private PersonRepository personRepository;
    private TaskRepository taskRepository;
    private CommentRepository commentRepository;

    @Autowired
    public AppService(PersonRepository personRepository, TaskRepository taskRepository, CommentRepository commentRepository) {
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public Person findPerson(Long personId) {
        return personRepository.findById(personId).get();
    }

    public Iterable<Person> listPeople() {
        return personRepository.findAll();
    }

    public void saveTask(Long personId, Task task) {
        Person person = personRepository.findById(personId).get();
        person.getPersontasks().add(task);
        personRepository.save(person);
        task.setTasksperson(person);
        taskRepository.save(task);
    }

    public Task findTask(Long id) {
        return taskRepository.findById(id).get();
    }

    public List<Task> listTasksByPerson(Long id) {
        return taskRepository.findAllByTasksperson_Id(id);
    }

    public void saveComment(Long personId, Long taskId, Comment comment) {
        Task task = taskRepository.findById(taskId).get();
        Person person = personRepository.findById(personId).get();
        task.getTaskcomments().add(comment);
        taskRepository.save(task);
        comment.setCommentstask(task);
        comment.setCommentsperson(person);
        commentRepository.save(comment);
        person.getPersoncomments().add(comment);
        personRepository.save(person);
    }

    public List<Comment> listCommentsByTaskId(Long taskId) {
        return commentRepository.findAllByCommentstask_Id(taskId);
    }

    public Iterable<Comment> listComments() {
        return commentRepository.findAll();
    }

    public Iterable<Task> listTasks() {
        return taskRepository.findAll();
    }
}
