/**   
 * Filename:    Cart.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-22
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.object.clone.newclone.clone;

/**
 * 
 * 
 * @author Yves He
 * 
 */
public class Cart implements Cloneable {

    private String id;
    private String creater;
    private Shop shop;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public Cart clone() throws CloneNotSupportedException {
        Cart cart = null;
        cart = (Cart) super.clone();

        Shop shopClone = this.shop.clone();
        this.setShop(shopClone);// 将本类中的引用成员继续clone后赋值给本类的clone对象
        return cart;
    }
}
