package com.evergrande.hdtms.model.teacher;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private Integer tPkId;

    private String tTaskId;

    private String tTutorId;

    private String tName;

    private Integer tCategory;

    private String tContent;

    private Integer tState;

    private Integer tTime;

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

    public Integer gettState() {
        return tState;
    }

    public void settState(Integer tState) {
        this.tState = tState;
    }

    public Integer gettTime() {
        return tTime;
    }

    public void settTime(Integer tTime) {
        this.tTime = tTime;
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
        return "Task{" +
                "tPkId=" + tPkId +
                ", tTaskId='" + tTaskId + '\'' +
                ", tTutorId='" + tTutorId + '\'' +
                ", tName='" + tName + '\'' +
                ", tCategory=" + tCategory +
                ", tContent='" + tContent + '\'' +
                ", tState=" + tState +
                ", tTime=" + tTime +
                ", tCreater='" + tCreater + '\'' +
                ", tCreateTime=" + tCreateTime +
                ", tOperator='" + tOperator + '\'' +
                ", tOperateDate=" + tOperateDate +
                '}';
    }
}