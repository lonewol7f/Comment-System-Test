package com.test.dao;

import com.test.entity.Comments;

import java.util.List;

/**
 * Created by Kalana on 20/07/2021
 */

public interface CommentDAO {

    List<Comments> getComments();
    Comments addComment(String username, String  comment);

}
