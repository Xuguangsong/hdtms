package com.evergrande.hdtms.model.teacher.modelPO;

/**
 * @author yangux
 * 接收前端页面的查询任务的条件
 */
public class SearchTaskConditionPO {
    private String startDate;
    private String endDate;
    private String taskName;
    private String stateStr;
    private int pageNo;             //参数第几页
    private int pageNum;            //参数每页显示数量

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "SearchTaskConditionPO{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", taskName='" + taskName + '\'' +
                ", stateStr='" + stateStr + '\'' +
                ", pageNo=" + pageNo +
                ", pageNum=" + pageNum +
                '}';
    }
}
