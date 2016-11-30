package cn.com.yves.object;

/**
 * 这是Object的源码,所以代码会报错
 * 
 * @author Yves He
 * 
 */
public class ObjectSource {// 第一步，将该函数封装在一个类中，即在这个类中声明该本地方法，需关键字 native
    // ，它会提醒编译器，该方法将在外部定义

    public static native void registerNatives();// 本地方法可以是静态的也可以是非静态的；

    static {
        registerNatives();
    }

    @Override
    public native int hashCode();

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    @Override
    protected native Object clone() throws CloneNotSupportedException;

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override
    protected void finalize() throws Throwable {
    }

    // 其他的final方法是不能被重写的.
}
