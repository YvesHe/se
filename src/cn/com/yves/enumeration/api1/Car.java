package cn.com.yves.enumeration.api1;

/**
 * 所有自定义的枚举都继承抽象类:java.lang.Enum
 * 
 * 注意:所有自定义枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。
 * 
 * @author Yves He
 * 
 */
public enum Car {

    /**
     * 定义枚举的实例:
     *
     * 每个实例的修饰权限是:public static final (类似下方定义的常量MESSAGE),
     *
     * 注意:也正是因为默认修饰权限是public static final所以不管何时获取到的枚举的实例都是同一个对象,可以理解成单例.
     *
     * Car.BAOMA == Car.valueOf("BAOMA") 返回true
     *
     * 书写建议:实例都是大写
     */
    BENCI, BAOMA, LANBOJINI;

    public static final String MESSAGE = "YVES";

}
