package com.evergrande.hdtms.web.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * json 接口成功返回对象
 *  <dl>
 *  <dt>类名：AjaxResultPo</dt>
 *  <dd>描述: </dd>
 *  <dd>公司: 恒大集团有限公司</dd>
 *  <dd>创建时间：2018-9-14  上午10:00:13</dd>
 *  <dd>创建人： 杨旭 </dd>
 *  </dl>
 */
public class AjaxResultPo implements Serializable {


    private static final long serialVersionUID = -4148768233386711389L;
    //消息串的最大长度
    public static Integer maxMassgeLength = 30;
    private boolean success;
    private String msg;
    private int res;
    private long total = -1;
    private Object rows;
    /**
     * @author : yangxu
     * @create : 2018.09.14 0030 12:37
     * @desc : 添加pages属性，用于传递分页参数
     */
    private Object pages;

    public AjaxResultPo(boolean b) {
        setSuccess(b);
        setMsg("");
    }

    public AjaxResultPo(boolean success, Object rows) {
        super();
        this.success = success;
        this.rows = rows;
    }

    public AjaxResultPo(boolean success, Object rows, Object pages) {
        super();
        this.success = success;
        this.rows = rows;
        this.pages = pages;
    }

    public AjaxResultPo(boolean b, String msg, long total, Object rows) {
        setSuccess(b);
        setMsg(msg);
        setTotal(total);
        setRows(rows);
    }

    public AjaxResultPo(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }

    public AjaxResultPo(boolean success, int res) {
        super();
        this.success = success;
        this.res = res;
    }


    //返回一个成功的消息对象
    public static AjaxResultPo success(String message, long total, Object rows) {
        return new AjaxResultPo(true, message, total, rows);
    }

    //缺省的成功消息对象
    public static AjaxResultPo successDefault() {
        return new AjaxResultPo(true, "操作成功", 0, null);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        msg = StringUtils.substring(msg, 0, maxMassgeLength);
        this.msg = msg;
    }

    public Object getPages() {
        return pages;
    }

    public void setPages(Object pages) {
        this.pages = pages;
    }
}
