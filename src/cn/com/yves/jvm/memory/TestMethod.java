/**   
 * Filename:    TestMethod.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-26 下午3:56:45   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 方法区 和 运行时常量(运行时常量是在方法区分配内存的): 也就是永久代内存溢出错误
 * 
 * 
 * Permanent Generation space,是指内存的永久代内存
 * 
 * @author Yves He
 * 
 */
public class TestMethod {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        int i = 1;
        while (true) {// 这里主要利用String的 intern方法创建了String对象后,如果没有在常量池中存放一份就
                      // 立马保存一份到常量池中.
            list.add(String.valueOf(++i).intern());
        }

        // 结果:java.lang.OutOfMemoryError: PermGen space

        // 这样也验证了运行时常量池是在方法区分配内存的(因为String的intern方法是保存在运行时常量池中的.)

        // 测试环境是JDK1.6 ,这个在JDK1.7中是不会出现相同结果(因为jdk1.7已经开始慢慢去永久代化了)

    }
}
