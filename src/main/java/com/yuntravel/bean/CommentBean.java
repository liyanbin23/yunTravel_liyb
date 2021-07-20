package com.yuntravel.bean;

import java.util.List;

public class CommentBean {

    private int id;
    private CommentUser commentUser;
    private TargetUser targetUser;
    private String content;
    private String createDate;
    private List<CommentBean> childrenList;

    public CommentBean() {
    }

    public CommentBean(int id, CommentUser commentUser, TargetUser targetUser, String content, String createDate, List<CommentBean> childrenList) {
        this.id = id;
        this.commentUser = commentUser;
        this.targetUser = targetUser;
        this.content = content;
        this.createDate = createDate;
        this.childrenList = childrenList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CommentUser getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(CommentUser commentUser) {
        this.commentUser = commentUser;
    }

    public TargetUser getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(TargetUser targetUser) {
        this.targetUser = targetUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<CommentBean> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<CommentBean> childrenList) {
        this.childrenList = childrenList;
    }
}
