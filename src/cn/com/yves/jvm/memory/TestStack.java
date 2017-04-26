/**   
 * Filename:    TestStack.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-26 下午3:25:02   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.jvm.memory;

/**
 * 虚拟机栈和本地方法溢出 本地方法栈存放的是基础的类型(int ,byte ... 和普通引用的指针)
 * 
 * @author Yves He
 * 
 */
public class TestStack {

    public static void main(String[] args) {
        Create create = new Create();

        try {

            while (true) {
                create.add();
            }

        } catch (StackOverflowError e) {
            System.out.println("此时的length:" + create.getLength());
            e.printStackTrace();
        }

        // StackOverflowError :当应用程序递归太深而发生堆栈溢出时，抛出该错误。
    }
}

class Create {

    private int length = 1;

    public void add() {
        length++;
        add();
    }

    public int getLength() {
        return length;
    }

}
