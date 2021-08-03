package com.test.controller;

import com.test.entity.Comments;
import com.test.entity.Replies;
import com.test.entity.Users;
import com.test.service.CommentService;
import com.test.service.ReplyService;
import com.test.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Kalana on 14/07/2021
 */

@Controller
public class DemoController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private Logger logger;

    @GetMapping("/")
    public String showHome() {
        return "home";
    }


    @GetMapping("comments/load")
    @ResponseBody
    public List<Comments> hello() {
        return commentService.getComments();
    }

    @GetMapping("users/getUser")
    @ResponseBody
    public Users getUser(@RequestParam("username") String userName) {
        return userService.getUser(userName);
    }

    @GetMapping("comments/add")
    @ResponseBody
    public Comments addComment(@RequestParam("comment") String comment, @RequestParam("username") String username) {
        return commentService.addComment(username, comment);
    }

    @GetMapping("replies/add")
    @ResponseBody
    public Replies addReply(@RequestParam("commentId") int commentId, @RequestParam("username") String username, @RequestParam("reply") String reply) {
        return replyService.addReply(reply, username, commentId);
    }

    @PostMapping("/test")
    public void test1(@RequestParam("name") String name) {
        System.out.println("awoooooooooooooooo " + name);
    }

}
