/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2017-1-6 下午4:31:18   
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
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("你好");
        list.add("最后");
        list.add("123");
        list.add("abc");
        list.add("bcd");
        list.add("a啊");

        /* 在一直比较类型时,也及时list<String>时候 ,可以写明确点 */
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return CompareUtill.CHINESECOMPARE.compare(o1, o2);
            }
        });

        /* 测试结果 */
        for (String ss : list) {
            System.out.println(ss);
        }

    }
}
