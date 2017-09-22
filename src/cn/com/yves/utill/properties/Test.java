/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-8-22 下午5:24:50   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.utill.properties;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Test {

    public static void main(String[] args) {
        Properties p1 = new Properties();
        p1.setProperty("a", "b");

    }

    public void demo1() {
        Properties command = new Properties();

        command.put("class", new Object());
        command.putAll(null);

        command.setProperty("a", "b");

        command.containsKey("a");

        boolean trustServerCertificate = command.getProperty("aa") != null;

    }

    public void demo2() {

        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(""));
            Properties registeredKeyPairs = new Properties();
            registeredKeyPairs.store(fileOutputStream, null); // ?

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void demo() {// 将值为String的 挑选出来
        Properties props = System.getProperties();
        Enumeration enu = props.propertyNames();
        while (enu.hasMoreElements()) {
            Object key = enu.nextElement();
            if (!(key instanceof String)) {
                continue;
            }
            Object value = props.getProperty(key.toString());
        }
    }

    public void demo4() {
        final Properties properties = System.getProperties();
        for (final String key : properties.stringPropertyNames()) {
            String property = properties.getProperty(key);
        }
    }

    /**
     * 将xml 格式的文件流 加载到Properties中 *
     * 
     * @param b
     * @return
     */
    public static Properties readProperties(byte b[]) {
        Properties prop = new Properties();
        try {
            if (b != null) {
                prop.loadFromXML(new ByteArrayInputStream(b));
            }
        } catch (IOException e) {
        }
        return prop;
    }

}
