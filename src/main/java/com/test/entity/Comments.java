package com.test.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kalana on 19/07/2021
 */

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // ---------------------------
    // @JoinColumn(name = "comment_id")
    // -------------------------
    private List<Replies> replies;

    public Comments() {
    }

    public Comments(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Replies> getReplies() {
        return replies;
    }
    //
    // public void setReplies(List<Replies> replies) {
    //     this.replies = replies;
    // }
}
