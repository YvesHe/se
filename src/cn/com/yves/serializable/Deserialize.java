/**   
 * Filename:    Deserialize.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-29 下午8:46:09   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-29 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化对象
 * 
 * @author Yves He
 * 
 */
public class Deserialize {
    public static void main(String[] args) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("files/Serializable/userBean.yves");// 从序列化文件中获取inputStream流
            ois = new ObjectInputStream(fis); // ObjectInputStream继承自InputStream

            UserBean userBean = (UserBean) ois.readObject();

            // 将序列化 的对象UserBean还原输出.
            System.out.println(userBean.getName());
            System.out.println(userBean.getAge());
            System.out.println(userBean.getSex());

        } catch (FileNotFoundException e) {// fis = new
                                           // FileInputStream("files/Serializable/userBean.ser")文件找不到会进这个异常.
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {// 调用ois.readObject()时,对于JVM可以反序列化对象，它必须是能够找到字节码的类。如果JVM在反序列化对象的过程中找不到该类，
                                            // 则抛出一个ClassNotFoundException异常。
            e.printStackTrace();
        }

    }
}