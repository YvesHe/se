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
package cn.com.yves.object.clone.newclone.clone;

import java.util.UUID;

public class Test {

    public static void main(String[] args) {
        Generic gen = new Generic();
        gen.setColor("red");
        gen.setSize(100);

        Shop shop = new Shop();
        shop.setName("baoma");
        shop.setPrice(100000);
        shop.setGen(gen);

        Cart cart = new Cart();
        cart.setCreater("Yves");
        cart.setId(UUID.randomUUID().toString());
        cart.setShop(shop);

        try {
            Cart cartClone = cart.clone();

            System.out.println(cartClone == cart);// false

            System.out.println(cartClone.getShop() == cart.getShop());// false

            System.out.println(cartClone.getShop().getGen() == cart.getShop().getGen());// true:
                                                                                        // 因为在Shop类中的成员Generic对象我没有实现克隆,系统默认是用的原来的引用.

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
