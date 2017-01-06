/**   
 * Filename:    Test2.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2017-1-6 下午6:05:54   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2017-1-6 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.utill.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("你好");
        list.add("最后");
        list.add("123");
        list.add("abc");
        list.add("bcd");
        list.add("a啊");

        /* arg1: list引用; arg2:Comparator引用 */
        Collections.sort(list, CompareUtill.CHINESECOMPARE);

        /* 测试结果 */
        for (String ss : list) {
            System.out.println(ss);
        }
    }

}
