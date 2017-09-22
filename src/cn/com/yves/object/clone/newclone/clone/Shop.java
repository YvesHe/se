/**   
 * Filename:    Shop.java   
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
public class Shop implements Cloneable {
    private String name;
    private double price;
    private Generic gen; // 一般的参数

    @Override
    public Shop clone() throws CloneNotSupportedException {
        return (Shop) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Generic getGen() {
        return gen;
    }

    public void setGen(Generic gen) {
        this.gen = gen;
    }

}
