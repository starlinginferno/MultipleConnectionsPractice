Just a basic toDo app with only add functions (so far)
Person class is in OneToMany connection with Task and Comment
Task class is in OneToMany connection with Comment and in ManyToOne connection with Person
Comment class is in ManyToOne connection with Person and Task

The secret is that FetchType can't be EAGER (persistence is probably important for delete method which I don't have atm) AND you have to set both the task and the person when you save the comment.