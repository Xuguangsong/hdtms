package com.evergrande.hdtms.common;

import java.util.UUID;

/**
 * 生成业务主键工具类，32位随机字符串，单实例环境不会出现碰撞
 * @author
 * @create 2018年7月11日10:13:20
 * @since 1.0.0
 */
public class Idkey {
    /**
     * JDK自带的UUID, 通过Random数字生成4段字节数组，去掉-后成32位
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
