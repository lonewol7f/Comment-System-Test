package com.test.service;

import com.test.dao.CommentDAO;
import com.test.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kalana on 20/07/2021
 */

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDAO commentDAO;

    @Override
    @Transactional
    public List<Comments> getComments() {
        return commentDAO.getComments();
    }
}
