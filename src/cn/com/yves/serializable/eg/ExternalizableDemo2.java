package cn.com.yves.serializable.eg;

/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-11 下午2:23:36   
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

/**
 * 
 * @author Yves He
 * 
 */
public class ExternalizableDemo2 {

    // 为了便于理解和节省篇幅，忽略关闭流操作及删除文件操作。真正编码时千万不要忘记
    // IOException直接抛出
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        // Write Obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "tempFile"));
        User2 user = new User2();
        user.setName("yves");
        user.setAge(23);
        oos.writeObject(user);

        // Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User2 newInstance = (User2) ois.readObject();

        // output
        System.out.println(newInstance); // User{name='yves', age=23}
    }
}