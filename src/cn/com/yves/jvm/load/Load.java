/**   
 * Filename:    Load.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-6 上午11:29:53   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.jvm.load;

public class Load {// 普通变量, 普通方法,都是在改类实例化之后才初始化的.

    public static void showMessage() {// 静态方法
        System.out.println("***static method!****");
        System.out.println(name);// yves
    }

    private static String name; // 这里是成员变量,
                                // final成员在设置值之前允许为null,一旦设置值之后就不许更改.
    private static String message = new String("hello");
    private static MyObject mObjectStatic = new MyObject() {
        @Override
        public void init() {
            System.out.println("static 成员变量初始化");

        }
    };

    static {// 这里是静态块
        System.out.println("*****static block*****");

        // address = "beijing"; //错误 非静态成员变量,晚于静态块加载.

        name = "yves";
        // name = "fads"; //错误 , final 变量一旦设置值就不许更改.

        System.out.println(Load.message);// 如果直接写 messag而不是Load.message
                                         // 则直接报错,原因是不能引用一个还没定义的字段
                                         // 写成Load.message 打印出来也还是null
                                         // 说明了,在同事static的状态下的静态块,静态
                                         // 成员,静态方法,是按代码的先后顺序加载的.

        System.out.println();

    }

    /* 下面是定义的非static的部分 */
    public void doSomething() {// 普通方法
        System.out.println("******普通方法*******");
        System.out.println(this.address);
        System.out.println(mObject);

    }

    private String address;

    {// 普通代码块
        System.out.println("****普通代码块 block***");
        this.address = "beijing";
    }

    private final MyObject mObject = new MyObject() {
        @Override
        public void init() {
            System.out.println("普通成员变量初始化");

        }
    };

}
