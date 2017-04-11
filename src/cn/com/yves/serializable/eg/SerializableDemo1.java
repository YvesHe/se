package cn.com.yves.serializable.eg;

/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-11 下午1:54:04   
 * Description:  
 *
 * Author       Yves He 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * 实现Serializable接口的普通序列化
 * 
 * @author Yves He
 * 
 */
public class SerializableDemo1 {

    public static void main(String[] args) {
        // Initializes The Object
        User1 user = new User1();
        user.setName("yves");
        user.setAge(23);
        System.out.println(user); // User{name='yves', age=23}

        // Write Obj to File
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }

        // Read Obj from File
        File file = new File("tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User1 newUser = (User1) ois.readObject();
            System.out.println(newUser); // User{name='yves', age=23}
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);
            try {
                FileUtils.forceDelete(file);// 将临时生成的文件删除
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
