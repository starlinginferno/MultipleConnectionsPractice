package com.multipleconnections.trial.repositories;

import com.multipleconnections.trial.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findAllByCommentsperson_Id(Long id);
}
