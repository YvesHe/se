/**   
 * Filename:    StaticClass.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 上午11:58:35   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.keyword.static_;

public class SuperClass {// static关键字不能修饰class

    public static String YVES_NAME = "Yves"; // static修饰成员变量,变量变常亮,值不可以修改了.

    public static void ShowMessage() {// static修饰方法,方法成静态方法,调用时可以直接用"类名.方法名":
                                      // StaticClass.ShowMessage();
        System.out.println("父类中的static方法!");
    }

    public static class InnerClass {// static 不能修饰普通类,但是可以修饰内部类,
                                    // 访问时类似:　"类名.静态成员": StaticClass.innerClass
                                    // 产生类innerClass的对象:"new  StaticClass.innerClass();"
        public void showInnerClassMessage() {
            System.out.println("父类中的内部类方法!");
        }
    }

    public class InnerClass2 {// 定义一个不是static的内部类

        public void showInnerClassMessage() {
            System.out.println("父类中普通内部类方法!");
        }
    }

    protected class InnerClass3 {// 定义一个受保护的内部类,该类就只能在通包和子类中访问.
    }

    private class InnerClass4 {// 定义一个私有的内部类,该类就只能在当前类SuperClass中访问
    }

}
