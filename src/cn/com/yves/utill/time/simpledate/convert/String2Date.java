/**   
 * Filename:    String2Date.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-22
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.utill.time.simpledate.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 关于SimpleDateFormat ,匹配模式部分的参数说明:"EEE MMM dd HH:mm:ss zzz yyyy"
 * 
 * E:星期
 * 
 * MM: 月
 * 
 * MMM: 大写月(比如: 九)
 * 
 * dd:天
 * 
 * 
 * HH:小时
 * 
 * 
 * mm:小时
 * 
 * ss:秒
 * 
 * zzz: CST
 * 
 * yyyy:年(yy表示年份后两位)
 * 
 * @author Yves He
 * 
 */
public class String2Date {

    public static void main(String[] args) {

        /*
         * 转换的时候,如果是格式不能完全匹配会出现异常,只允许需要转换的文本比pattern有更加多的格式.
         * 
         * 如:
         * 
         * pattern = "yyyy-MM-dd HH:mm:ss E";
         * 
         * source = "2017-09-22 13:55:60";时会出现异常
         * 
         * pattern = "yyyy-MM-dd"; source = "2017-09-22 13:55:60";是不会出现异常.
         */
        try {
            /* 模式匹配一 */
            String pattern = "yyyy-MM-dd HH:mm";
            String source = "2017-09-22 13:55:60";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            Date parse = format.parse(source);
            System.out.println(parse);// Fri Sep 22 13:55:00 CST 2017
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
