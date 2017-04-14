/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2017-1-9 下午5:37:28   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2017-1-9 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.collection.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    Hashtable<String, String> hashTable = null; // 线程安全

    ConcurrentHashMap<String, String> conMap = null;// 线程安全

    HashSet<String> set = null;

    StringBuffer sb = null;// 线程安全

    System ss = null;

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();// 线程不安全
        hashMap.put("name", "yves1");
        hashMap.put("name", "yves1");

        while (true) {
            try {
                System.out.println(hashMap.size());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
