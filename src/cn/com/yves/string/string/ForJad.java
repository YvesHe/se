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

public class ForJad {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";

        String s3 = "ab";
        String s4 = "a" + "b";
        String s5 = s1 + s2;
        String s6 = "a" + s2;

        System.out.println(s3 == s4);// true
        System.out.println(s3 == s5);// false
        System.out.println(s4 == s5);// false
        System.out.println(s4 == s6);// false

        System.out.println();

    }

}
