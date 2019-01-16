package com.multipleconnections.trial.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "commentstask", targetEntity = Comment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> taskcomments;

    @ManyToOne
    @JoinColumn(name="persontasks_id")
    private Person tasksperson;

    public Task(String title) {
        this.title = title;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getTaskcomments() {
        return taskcomments;
    }

    public void setTaskcomments(List<Comment> taskcomments) {
        this.taskcomments = taskcomments;
    }

    public Person getTasksperson() {
        return tasksperson;
    }

    public void setTasksperson(Person tasksperson) {
        this.tasksperson = tasksperson;
    }
}
