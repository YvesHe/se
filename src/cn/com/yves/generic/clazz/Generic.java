/**   
 * Filename:    aa.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-29 下午3:19:46   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-29 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.generic.clazz;

/**
 * 定义一个泛型类, 规则: 在类名后面添加要定义的泛型<T> T可以为任意的变量
 * 
 * @author Yves He
 * 
 * @param <T>
 */
public class Generic<T> {// 声明泛型类 : 在类名 后面声明 泛型,声明改类为泛型类 T ;
                      // 然后在改类中就可以用泛型变量了.泛型参数通过 实例化化时进行赋值

    public Generic(String message) {// 构造函数中的参数和 泛型类中定义的泛型变量互相不冲突,可以一起使用.
    }

    // 由于是定义的泛型类,所以在该类中就可以用改值了.
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

}