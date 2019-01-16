package com.multipleconnections.trial.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    @OneToMany(mappedBy = "tasksperson", targetEntity = Task.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Task> persontasks;

    @OneToMany(mappedBy = "commentsperson", targetEntity = Comment.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Comment> personcomments;

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getPersontasks() {
        return persontasks;
    }

    public void setPersontasks(List<Task> persontasks) {
        this.persontasks = persontasks;
    }

    public List<Comment> getPersoncomments() {
        return personcomments;
    }

    public void setPersoncomments(List<Comment> personcomments) {
        this.personcomments = personcomments;
    }
}
