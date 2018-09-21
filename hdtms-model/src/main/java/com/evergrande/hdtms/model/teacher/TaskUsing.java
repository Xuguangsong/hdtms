package com.evergrande.hdtms.model.teacher;

import java.util.Date;

public class TaskUsing {
    private Integer tPkId;

    private String tTaskId;

    private String tTutorId;

    private String tStuId;

    private String tName;

    private Integer tCategory;

    private String tContent;

    private Integer tProgress;

    private Integer tTime;

    private String tFeedback;

    private Date tStartDate;

    private Date tExpirationDate;

    private Date tFinishDate;

    private String tCreater;

    private Date tCreateTime;

    private String tOperator;

    private Date tOperateDate;

    public Integer gettPkId() {
        return tPkId;
    }

    public void settPkId(Integer tPkId) {
        this.tPkId = tPkId;
    }

    public String gettTaskId() {
        return tTaskId;
    }

    public void settTaskId(String tTaskId) {
        this.tTaskId = tTaskId == null ? null : tTaskId.trim();
    }

    public String gettTutorId() {
        return tTutorId;
    }

    public void settTutorId(String tTutorId) {
        this.tTutorId = tTutorId == null ? null : tTutorId.trim();
    }

    public String gettStuId() {
        return tStuId;
    }

    public void settStuId(String tStuId) {
        this.tStuId = tStuId == null ? null : tStuId.trim();
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public Integer gettCategory() {
        return tCategory;
    }

    public void settCategory(Integer tCategory) {
        this.tCategory = tCategory;
    }

    public String gettContent() {
        return tContent;
    }

    public void settContent(String tContent) {
        this.tContent = tContent == null ? null : tContent.trim();
    }

    public Integer gettProgress() {
        return tProgress;
    }

    public void settProgress(Integer tProgress) {
        this.tProgress = tProgress;
    }

    public Integer gettTime() {
        return tTime;
    }

    public void settTime(Integer tTime) {
        this.tTime = tTime;
    }

    public String gettFeedback() {
        return tFeedback;
    }

    public void settFeedback(String tFeedback) {
        this.tFeedback = tFeedback == null ? null : tFeedback.trim();
    }

    public Date gettStartDate() {
        return tStartDate;
    }

    public void settStartDate(Date tStartDate) {
        this.tStartDate = tStartDate;
    }

    public Date gettExpirationDate() {
        return tExpirationDate;
    }

    public void settExpirationDate(Date tExpirationDate) {
        this.tExpirationDate = tExpirationDate;
    }

    public Date gettFinishDate() {
        return tFinishDate;
    }

    public void settFinishDate(Date tFinishDate) {
        this.tFinishDate = tFinishDate;
    }

    public String gettCreater() {
        return tCreater;
    }

    public void settCreater(String tCreater) {
        this.tCreater = tCreater == null ? null : tCreater.trim();
    }

    public Date gettCreateTime() {
        return tCreateTime;
    }

    public void settCreateTime(Date tCreateTime) {
        this.tCreateTime = tCreateTime;
    }

    public String gettOperator() {
        return tOperator;
    }

    public void settOperator(String tOperator) {
        this.tOperator = tOperator == null ? null : tOperator.trim();
    }

    public Date gettOperateDate() {
        return tOperateDate;
    }

    public void settOperateDate(Date tOperateDate) {
        this.tOperateDate = tOperateDate;
    }

    @Override
    public String toString() {
        return "TaskUsing{" +
                "tPkId=" + tPkId +
                ", tTaskId='" + tTaskId + '\'' +
                ", tTutorId='" + tTutorId + '\'' +
                ", tStuId='" + tStuId + '\'' +
                ", tName='" + tName + '\'' +
                ", tCategory=" + tCategory +
                ", tContent='" + tContent + '\'' +
                ", tProgress=" + tProgress +
                ", tTime=" + tTime +
                ", tFeedback='" + tFeedback + '\'' +
                ", tStartDate=" + tStartDate +
                ", tExpirationDate=" + tExpirationDate +
                ", tFinishDate=" + tFinishDate +
                ", tCreater='" + tCreater + '\'' +
                ", tCreateTime=" + tCreateTime +
                ", tOperator='" + tOperator + '\'' +
                ", tOperateDate=" + tOperateDate +
                '}';
    }
}