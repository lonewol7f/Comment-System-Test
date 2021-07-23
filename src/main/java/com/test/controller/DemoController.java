package com.test.controller;

import com.test.entity.Comments;
import com.test.service.CommentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kalana on 14/07/2021
 */

@Controller
public class DemoController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private Logger logger;

    @GetMapping("/")
    public String showHome(){

        // System.out.println("=============================================================================================================================");
        //
        // List<List<Object>> comments = commentService.getComments();
        //
        // for (List<Object> list :comments) {
        //     Comments comment = (Comments) list.get(0);
        //     System.out.println(comment.getComment());
        //
        //     List<Replies> replies = (List<Replies>) list.get(1);
        //     for (Replies reply :replies) {
        //         System.out.println("========>> " + reply.getReply());
        //     }
        // }
        //
        // System.out.println("=============================================================================================================================");

        return "home";
    }



    @GetMapping("/hello")
    @ResponseBody
    public List<Comments> hello(@RequestParam("COMMENT") String comment){
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println(comment);
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");
        System.out.println("=============================================================================================================================");

        return commentService.getComments();
    }

}
