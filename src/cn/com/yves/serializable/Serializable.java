/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-29 下午8:24:25   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-29 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化对象
 * 
 * @author Yves He
 * 
 */
public class Serializable {

    public static void main(String[] args) {

        UserBean userBean = new UserBean();
        userBean.setName("Yves");
        userBean.setAge(23);
        userBean.setSex('男');

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {

            fos = new FileOutputStream("files/Serializable/userBean.yves");// 生成序列化文件,文件不存在,会自动创建,后缀可以随便取,但是一般为.ser
            oos = new ObjectOutputStream(fos);

            oos.writeObject(userBean);// 将可以序列化的对象通过writeObject写在硬盘上.

            System.out.println("对象userBean序列化成功!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}