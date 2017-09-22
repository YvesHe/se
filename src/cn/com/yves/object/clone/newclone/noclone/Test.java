/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-22
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.object.clone.newclone.noclone;

import java.util.UUID;

public class Test {

    /**
     * 原始类型(int,double,String...)的字段复制会得到新的值地址,但是引用类型(如自己定义的JavaBean)
     * 系统默认是使用原对象的引用,也就是说clone后对象的引用型成员依旧是指向原来的地址. 这也就是常说的系统默认的克隆是浅层次的克隆.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Generic gen = new Generic();
        gen.setColor("red");
        gen.setSize(100);

        Shop shop = new Shop();
        shop.setName("BMW");
        shop.setPrice(100000);
        shop.setGen(gen);

        Cart cart = new Cart();
        cart.setCreater("Yves");
        cart.setId(UUID.randomUUID().toString());
        cart.setShop(shop);

        try {
            Cart cartClone = cart.clone();

            System.out.println(cartClone == cart);// false

            System.out.println(cartClone.getShop() == cart.getShop());// true,
                                                                      // 可见系统默认的克隆是没有对引用型进行克隆,而是保留了原来的引用,也不是为null

            System.out.println(cartClone.getShop().getGen() == cart.getShop().getGen());// true,原理同上

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
