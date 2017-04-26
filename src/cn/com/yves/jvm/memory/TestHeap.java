/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-26 下午2:14:58   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 java堆内存溢出
 * 
 * @author Yves He
 * 
 */
public class TestHeap {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();

        while (true) {
            list.add(new Yves());
        }

        // 不一会就出现了 java.lang.OutOfMemoryError内存溢出异常
    }
}

class Yves {

}
