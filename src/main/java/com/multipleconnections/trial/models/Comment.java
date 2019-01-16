package com.multipleconnections.trial.models;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name="personcomments_id")
    private Person commentsperson;

    @ManyToOne
    @JoinColumn(name="taskcomments_id")
    private Task commentstask;

    public Comment(String content) {
        this.content = content;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Person getCommentsperson() {
        return commentsperson;
    }

    public void setCommentsperson(Person commentsperson) {
        this.commentsperson = commentsperson;
    }

    public Task getCommentstask() {
        return commentstask;
    }

    public void setCommentstask(Task commentstask) {
        this.commentstask = commentstask;
    }
}
