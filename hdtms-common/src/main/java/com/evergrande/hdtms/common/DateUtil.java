package com.evergrande.hdtms.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * @author yangxu
     * @param date String类型date: "2018-12-12"
     * @param split 日期分隔符
     * @return 返回 java.util.Date 对象
     * @throws ParseException 不匹配的类型异常
     */
    public static Date strToUtlDate(String date,char split) throws ParseException{
        return new Date(new SimpleDateFormat("yyyy"+split+"MM"+split+"dd").parse(date).getTime());
    }
}
