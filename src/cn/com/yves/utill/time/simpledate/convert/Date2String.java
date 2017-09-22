/**   
 * Filename:    Date2String.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-22
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.utill.time.simpledate.convert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class Date2String {

    public static void main(String[] args) {

        /* 默认的toString的格式 */
        System.out.println(new Date()); // Fri Sep 22 10:40:07 CST 2017

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime()); // Fri Sep 22 10:40:07 CST 2017

        /* 模式匹配一 */
        String pattern = "yyyy-MM-dd HH:mm:ss E";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String dateStr = format.format(new Date());
        System.out.println(dateStr);// 2017-09-22 10:26:22 星期五

        /* 模式匹配二 */
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        String dateStr2 = format2.format(new Date());
        System.out.println(dateStr2); // 2017年09月22日 10时29分08秒 星期五

        /* 模式匹配三 */
        SimpleDateFormat format3 = new SimpleDateFormat(" MM dd HH:mm:ss zzz yy");
        String dateStr3 = format3.format(new Date());
        System.out.println(dateStr3); // 2017年09月22日 10时29分08秒 星期五

    }

}

/* Date 的toString()方法的源码 */
// public String toString() {
// // "EEE MMM dd HH:mm:ss zzz yyyy";
// BaseCalendar.Date date = normalize();
// StringBuilder sb = new StringBuilder(28);
// int index = date.getDayOfWeek();
// if (index == gcal.SUNDAY) {
// index = 8;
// }
// convertToAbbr(sb, wtb[index]).append(' '); // EEE
// convertToAbbr(sb, wtb[date.getMonth() - 1 + 2 + 7]).append(' '); // MMM
// CalendarUtils.sprintf0d(sb, date.getDayOfMonth(), 2).append(' '); // dd
//
// CalendarUtils.sprintf0d(sb, date.getHours(), 2).append(':'); // HH
// CalendarUtils.sprintf0d(sb, date.getMinutes(), 2).append(':'); // mm
// CalendarUtils.sprintf0d(sb, date.getSeconds(), 2).append(' '); // ss
// TimeZone zi = date.getZone();
// if (zi != null) {
// sb.append(zi.getDisplayName(date.isDaylightTime(), zi.SHORT, Locale.US)); //
// zzz
// } else {
// sb.append("GMT");
// }
// sb.append(' ').append(date.getYear()); // yyyy
// return sb.toString();
// }
