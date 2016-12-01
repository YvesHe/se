/**   
 * Filename:    a.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-1 下午6:01:09   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-1 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.annotation.ormframe;

import cn.com.yves.annotation.ormframe.annotation.FruitColor;
import cn.com.yves.annotation.ormframe.annotation.FruitColor.Color;
import cn.com.yves.annotation.ormframe.annotation.FruitName;
import cn.com.yves.annotation.ormframe.annotation.FruitProvider;

public class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void displayName() {
        System.out.println("水果的名字是：苹果");
    }
}