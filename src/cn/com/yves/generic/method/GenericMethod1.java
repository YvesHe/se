/**   
 * Filename:    MaximumTest.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-29 下午3:05:09   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-29 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.generic.method;

public class GenericMethod1 {

    /**
     * 比较三个值并返回最大值, 限制类型的泛型T extends Comparable<T> : T必须继承Comparable<T>
     * 
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {// 定义T
                                                                      // 是继承自Comparable的类型
        T max = x; // 假设x是初始最大值
        if (y.compareTo(max) > 0) {
            max = y; // y 更大
        }
        if (z.compareTo(max) > 0) {
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

    /**
     * 测试
     * 
     * @param <T>
     * 
     * @param args
     */
    public static void main(String args[]) {

        System.out.println("Max of 3, 4 and 5 is:" + maximum(3, 4, 5));

        System.out.println("Maxm of 6.6, 8.8 and 7.7 is:"
                + maximum(6.6, 8.8, 7.7));

        System.out.printf("Max of pear ,apple and orange is : "
                + maximum("pear", "apple", "orange"));
    }
}