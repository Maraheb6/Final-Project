package com.example.finalproject.Service;

import com.example.finalproject.ApiException.ApiException;
import com.example.finalproject.Model.Comment;
import com.example.finalproject.Model.Services;
import com.example.finalproject.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    //get all Comments
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
    //get Comment by id
        public Comment getCommentById(Integer id){
        Comment comment=commentRepository.findCommentById(id);
        if (comment==null){
            throw new ApiException("Comment Not Found!");
        }
        return comment;
    }
    //add Comment
    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    //update Comment
    public void updateComment( Comment comment,Integer id){
        Comment oldComment=commentRepository.findCommentById(id);
        if(oldComment==null){
            throw new ApiException("Comment Not Found");
        }
        oldComment.setId(id);
        oldComment.setMessage(comment.getMessage());
        oldComment.setRating(comment.getRating());

        commentRepository.save(oldComment);
    }
    //delete Comment

    public void deleteComment(Integer id){
        Comment comment=commentRepository.findCommentById(id);
        if(comment==null){
            throw new ApiException("Comment Not Found");
        }
        commentRepository.delete(comment);
    }
}
