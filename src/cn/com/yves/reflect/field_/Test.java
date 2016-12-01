/**   
 * Filename:    Reflect.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 上午10:10:26   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.reflect.field_;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射属性field
 * 
 * @author Yves He
 * 
 */
public class Test {

    public static void main(String[] args) {

        Class<UtillClass> clazz = UtillClass.class;

        /* 获取类中所有"声明的字段" */
        System.out.println("***获取UtillClass类中所有声明的属性的类型和值***");
        Field[] fieldDec = clazz.getDeclaredFields(); // 返回该类中所有声明的的字段：成员字段
        for (Field f : fieldDec) {// 遍历所有属性的值
            f.setAccessible(true);// 打开访问权限
            System.out.println(f.getModifiers());

            /* 获取字段的修饰权限.,还有其他的修饰符 */
            if (f.getModifiers() == Modifier.PUBLIC) {
                System.out.print("public ");
            }
            if (f.getModifiers() == Modifier.PRIVATE) {
                System.out.println("in**");
                System.out.print("private ");
            }
            if (f.getModifiers() == Modifier.PROTECTED) {
                System.out.print("protected ");
            }

            if (f.getModifiers() == Modifier.FINAL) {
                System.out.print("final ");
            }

            // 获取字段的修饰符

            Class<?> type = f.getType();// 获取每一字段的定义的类型的字节码

            try {// 8大原始型

                if (type.getName().equals("int")) {
                    int temp = f.getInt(new UtillClass());
                    System.out.println("int " + f.getName() + " = " + temp);
                }

                if (type.getName().equals("float")) {
                    float temp = f.getFloat(new UtillClass());
                    System.out.println("float " + f.getName() + " = " + temp);
                }

                if (type.getName().equals("double")) {
                    double temp = f.getDouble(new UtillClass());
                    System.out.println("double " + f.getName() + " = " + temp);
                }
                if (type.getName().equals("byte")) {
                    byte temp = f.getByte(new UtillClass());
                    System.out.println("byte " + f.getName() + " = " + temp);
                }
                if (type.getName().equals("java.lang.String")) {
                    String temp = (String) f.get(new UtillClass());
                    System.out.println("java.lang.String " + f.getName()
                            + " = " + temp);
                }
                // ...公共8个,没写完

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        /* 获取指定的"声明的字段" */
        System.out.println("***知道要反射属性的类型和属性名时,获取信息***");
        try {
            Field declaredField = clazz.getDeclaredField("namePrivate");
            declaredField.setAccessible(true);// 跳过JVM检测,打开访问权限.(类似打开访问方法的权限一样操作)

            int namePrivate = declaredField.getInt(new UtillClass());// 如果字段没有设置初始值:引用设置为null,原始型为0
            System.out.println("int namePrivate = " + namePrivate);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /* 获取所有的"public的字段":包括父类中public字段和实现接口的字段 */
        System.out.println("***获取所有的public的字段***");
        Field[] fieldPub = clazz.getFields();
        for (Field f : fieldPub) {
            System.out.println(f.getName());
        }

    }
}
