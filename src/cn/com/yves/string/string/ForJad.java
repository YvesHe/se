/**   
 * Filename:    ForJad.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-10 下午5:55:11   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.string.string;

/**
 * 关于String 的 + 操作
 * 
 * @author Yves He
 * 
 */
public class ForJad {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";

        String s3 = "ab";
        String s4 = "a" + "b";// 常量折叠 在编译的是编译器会想将 "a"+"b"算出来 本质是String s4 ="ab";
        String s5 = s1 + s2;
        String s6 = "a" + s2;

        System.out.println(s3 == s4);// true
        System.out.println(s3 == s5);// false
        System.out.println(s4 == s5);// false
        System.out.println(s4 == s6);// false

        System.out.println();

        String s7 = "a" + "b" + s1 + s2; // 先将"a" "b" 算出来再
                                         // 一直调用append()方法后toString();
    }
}
// 反编译结果:
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: ForJad.java
//
// package cn.com.yves.string.string;
//
// import java.io.PrintStream;
//
// public class ForJad
// {
//
// public ForJad()
// {
// }
//
// public static void main(String args[])
// {
// String s1 = "a";
// String s2 = "b";
// String s3 = "ab";
// String s4 = "ab";
// String s5 = (new StringBuilder(String.valueOf(s1))).append(s2).toString();
// String s6 = (new StringBuilder("a")).append(s2).toString();
// System.out.println(s3 == s4);
// System.out.println(s3 == s5);
// System.out.println(s4 == s5);
// System.out.println(s4 == s6);
// System.out.println();
// String s7 = (new StringBuilder("ab")).append(s1).append(s2).toString();
// }
// }

