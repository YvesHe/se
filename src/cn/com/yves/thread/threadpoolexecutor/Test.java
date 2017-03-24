/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-21 下午6:10:57   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.threadpoolexecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = null;
        ArrayBlockingQueue arrayQueue = null;

        // Iterable<String> conCollection = new ArrayList<String>();
        // conCollection.iterator();

        Collection<String> collection = new ArrayList<String>();

        collection.add("1");
        collection.add("2");
        collection.add("3");

        collection.add("yves");

        Object[] array = collection.toArray(new Object[20]);// 这个方法只能向上转型
                                                            // 分析源码得出,当传入的数组小,则使用collection的大小
                                                            // 否则使用传入参数的大小,不足的部分都设置成null

        System.out.println(array[0]);
        System.out.println(array.length);

    }
}
