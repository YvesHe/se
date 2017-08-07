/**   
 * Filename:    TreeSetTest.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-7-31 下午5:12:45   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.container.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet是有序的, 按照元素的某种规则排序.
 * 
 * @author Yves He
 * 
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("orange");
        ts.add("apple");
        ts.add("banana");
        ts.add("grape");

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            String fruit = (String) it.next();
            System.out.println(fruit);
        }
    }
}
