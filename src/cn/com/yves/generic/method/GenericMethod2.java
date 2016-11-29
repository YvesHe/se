/**   
 * Filename:    GenericMethodTest.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-29 下午2:57:23   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-29 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.generic.method;

public class GenericMethod2 {

    /**
     * 泛型方法:含两个泛型参数的泛型方法
     * 
     * @param inputArray
     */
    public static <E, E2> void printArray(E[] inputArray) {

        // 如果要用到E2 可以在改方法上多写一个方法参数.就可以在改方法中使用该泛型了.

        // 输出数组元素
        for (E element : inputArray) {// 这里的element没有什么特殊的意义 ,就是用for
                                      // each时的一个局部变量.

            System.out.println(element);
        }
        System.out.println();
    }

    public static <E, E2> void showClass() {
        E e = null;
        System.out.println(e.getClass());
    }

    /**
     * 测试
     * 
     * @param args
     */
    public static void main(String args[]) {

        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("Array integerArray contains:");
        printArray(intArray); // 传递一个整型数组

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray); // 传递一个双精度型数组

        System.out.println("\nArray characterArray contains:");
        printArray(charArray); // 传递一个字符型型数组

        showClass();
    }

}