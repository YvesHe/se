package cn.com.yves.enumeration.api2;

public class Test {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // 获取枚举实例
        Phone iphone = Phone.IPHONE;
        int capacity = iphone.getCapacity();// 64
        String phoneTye = iphone.getPhoneTye();// iphone7

        // 调用Enum中的方法
        String name = iphone.name();// IPHONE
        int ordinal = iphone.ordinal();// 0

        // 调用自定义函数
        String returnHello = iphone.returnHello();// hello

        /* 调用重写后的方法 */
        String toStr = iphone.toString();// iphone7:64

        System.out.println();
    }
}
