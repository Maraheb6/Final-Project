package com.example.finalproject.Repository;

import com.example.finalproject.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment findCommentById(Integer id);
}
