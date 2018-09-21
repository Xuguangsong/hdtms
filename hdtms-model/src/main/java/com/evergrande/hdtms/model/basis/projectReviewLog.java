package com.evergrande.hdtms.model.basis;

import java.util.Date;

public class projectReviewLog {
    private Integer id;

    private String reviewId;

    private Integer projectId;

    private String theme;

    private String privateId;

    private Byte reviewOperate;

    private Integer operatorId;

    private String operatorComment;

    private Integer creatorId;

    private Date createTime;

    private Integer modifierId;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId == null ? null : reviewId.trim();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getPrivateId() {
        return privateId;
    }

    public void setPrivateId(String privateId) {
        this.privateId = privateId == null ? null : privateId.trim();
    }

    public Byte getReviewOperate() {
        return reviewOperate;
    }

    public void setReviewOperate(Byte reviewOperate) {
        this.reviewOperate = reviewOperate;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorComment() {
        return operatorComment;
    }

    public void setOperatorComment(String operatorComment) {
        this.operatorComment = operatorComment == null ? null : operatorComment.trim();
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getModifierId() {
        return modifierId;
    }

    public void setModifierId(Integer modifierId) {
        this.modifierId = modifierId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}