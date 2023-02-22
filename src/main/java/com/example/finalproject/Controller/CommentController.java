package com.example.finalproject.Controller;

import com.example.finalproject.ApiResponse.ApiResponse;
import com.example.finalproject.Model.Address;
import com.example.finalproject.Model.Comment;
import com.example.finalproject.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    // get all Comments
    @GetMapping("/get-all")
    public ResponseEntity getAllComments(){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAllComments());
    }

    //get Comment by id
    @GetMapping("get-by-id/{id}")
    public ResponseEntity getCommentById(@PathVariable Integer id ){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentById(id));
    }

    //add  Comment
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid Comment comment){
        commentService.addComment(comment);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Comment Added"));
    }
    //update Comment
    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@RequestBody @Valid Comment comment, @PathVariable Integer id){
        commentService.updateComment(comment,id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Comment Updated"));
    }

    //delete Comment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Comment deleted"));
    }

}
