/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-30 下午2:06:33   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-30 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.keyword.static_;

import cn.com.yves.keyword.static_.SuperClass.InnerClass;
import cn.com.yves.keyword.static_.SuperClass.InnerClass2;

public class Test {
    public static void main(String[] args) {

        /* 调用static属性 */
        System.out.println(SuperClass.YVES_NAME);

        /* 调用static方法 */
        SuperClass.ShowMessage();
        ChildClass.ShowMessage();

        SuperClass sc = new ChildClass();
        sc.ShowMessage();// 父的引用调用的还是父类中的方法.没有多肽的概念.结果还是:"Hello! It's Class StaticClass"
                         // ps:静态方法一般通过"类名.方法名":StaticClassShowMessage()直接调用

        /*
         * 访问一个类的内部类的注意: 在外部访问一个类的内部内,要注意的是访问权限的修饰(public,private...),
         * 其次只是根据内部类的是不是静态类(static)而采取不同的书写格式
         */

        /* 调用static内部类 */
        InnerClass innerClass = new SuperClass.InnerClass();// 产生内部类的对象.
        innerClass.showInnerClassMessage();// 调用内部类的方法.

        /* 访问普通内部类 */
        InnerClass2 innerClass2 = new SuperClass().new InnerClass2();// 可以理解成先产生一个SuperClass对象
                                                                     // 再对改对象里的普通成员类InnerClass2实例化

        new SuperClass().new InnerClass3();

        // new SuperClass().new InnerClass4(); 访问不到该内部类,报错.

    }
}
