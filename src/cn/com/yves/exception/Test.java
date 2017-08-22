/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-8-7 下午4:13:51   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test {

    public static void main(String[] args) {

        try {

            throw new InfraException("nihao", new NullPointerException());
        } catch (Exception e) {// 真正代码有了异常

            // 获取异常的message 和cause
            e.getMessage();// 构造异常构造方法中的message,返回的是String
            Throwable cause = e.getCause(); // 获取异常构造方法中的cause,返回的是Throwable对象,
                                            // 实际的类型是NullPointerException

            // 捕获异常后处理
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(new File("heyu.log"));
                e.printStackTrace(pw);
            } catch (FileNotFoundException e1) {
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }
        }

    }
}
