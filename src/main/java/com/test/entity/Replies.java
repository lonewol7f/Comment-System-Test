package com.test.entity;

import javax.persistence.*;

/**
 * Created by Kalana on 19/07/2021
 */


@Entity
@Table(name = "replies")
public class Replies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "reply")
    private String reply;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private Users user;

    // -------------------------------------
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comments comment;
    // -------------------------------------

    public Replies() {
    }

    public Replies(String reply) {
        this.reply = reply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    // --------------------------
    // public Comments getComment() {
    //     return comment;
    // }
    //
    // public void setComment(Comments comment) {
    //     this.comment = comment;
    // }
}
