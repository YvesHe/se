/**   
 * Filename:    ChineseCompare.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2017-1-6 下午3:03:39   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2017-1-6 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.utill.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class CompareUtill {

    public static final Comparator<Object> CHINESECOMPARE = new ChineseCompare<Object>();

    private static Collator CHINESE_COLLATOR = Collator
            .getInstance(Locale.CHINA);// Collator 类执行区分语言环境的
                                       // String比较(比如中文环境下String的比较).
                                       // getInstance() 获取当前默认语言环境的 Collator.
                                       // getInstance(Locale
                                       // desiredLocale)获取所需语言环境的 Collator。

    /**
     * 中文比较器
     * 
     * 定义一个内部类ChineseCompare,由于成员CHINESECOMPARE 是static 故该内部类应该定义成static
     * 
     * @author Yves He
     * 
     * @param <T>
     */
    public static class ChineseCompare<T> implements Comparator<T> {// Comparator该比较接口就两个方法:
                                                                    // compare;equals

        @Override
        public int compare(T o1, T o2) {// 参数详解 -1: 小于? , 0: 等于 , 1: 大于

            /* 对null值的处理 */
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }

            /* 按数字的排序(针对的是那些实现了比较接口comparable的: 类似Integer) */
            if (o1 instanceof Comparable && o2 instanceof Comparable
                    && o1 instanceof Number && o2 instanceof Number) {
                int result = ((Comparable) o1).compareTo(o2);// 两个实现了比较接口的对象可以进行比较,返回值为:-1;0;1
                return result;
            }

            /* 按字符串的排序: 包括了英文字符和中文字符 */
            if (o1 instanceof Comparable && o2 instanceof Comparable
                    && o1 instanceof String && o2 instanceof String) {// String
                                                                      // 也实现了comparable接口

                // 方法一: 利用实现了comparable接口的比较
                // int result = ((Comparable) o1).compareTo(o2);
                // return result;

                // 方法二: 利用Collator对象compare方法比较
                // compare(String s1,String s2)和
                // compare(Object o1,Object o2)源码都是比较的
                int result = CHINESE_COLLATOR.compare(o1, o2);
                return result;

            }

            /* 按业务排序:　比如按某javaBean 的name属性排序: 利用发射技术 (前提该Bean有name属性提供了共有的get方法) */
            try {
                Method method = o1.getClass().getMethod("getName");
                String name1 = (String) method.invoke(o1);

                Method method2 = o2.getClass().getMethod("getName");
                String name2 = (String) method.invoke(o2);

                // 空值处理
                if (name1 == null) {
                    name1 = "";
                }
                if (name2 == null) {
                    name2 = "";
                }

                int result = CHINESE_COLLATOR.compare(name1, name2);
                return result;

            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            return CHINESE_COLLATOR.compare(o1.toString(), o2.toString());// 以上条件都不满足条件时就比较toString返回.

        }
    }
}
