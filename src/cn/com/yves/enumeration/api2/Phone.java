package cn.com.yves.enumeration.api2;

/**
 * 枚举 --相当于类的概念
 *
 * @author Yves He
 *
 */
public enum Phone {

    /* 定义枚举Phone的实例(一定得放在第一行),相当于在构造方法中传入了两个参数 ,参数可以是多个,与相应的构造函数相匹配 */
    IPHONE("iphone7", 64), SUMSING("S8", 128), NOKIA("Nokia6", 64);

    private String phoneTye;
    private int capacity;

    private Phone(String phoneTye, int capacity) {// 该构造方法一定不能是public权限的.
        System.out.println("in");// 定义了多少个枚举Phone实例,该构造方法就执行多少次,这里是3次.

        this.phoneTye = phoneTye;
        this.capacity = capacity;
    }

    /* 自定义方法 */
    public String returnHello() {
        return "hello";
    }

    /* 重写方法 */
    @Override
    public String toString() {
        return this.phoneTye + ":" + this.capacity;
    }

    /* get set */
    public String getPhoneTye() {
        return phoneTye;
    }

    public void setPhoneTye(String phoneTye) {
        this.phoneTye = phoneTye;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
