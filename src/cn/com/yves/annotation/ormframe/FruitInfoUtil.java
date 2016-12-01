/**   
 * Filename:    FruitInfoUtil.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-1 下午6:01:58   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-1 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.annotation.ormframe;

import java.lang.reflect.Field;

import cn.com.yves.annotation.ormframe.annotation.FruitColor;
import cn.com.yves.annotation.ormframe.annotation.FruitName;
import cn.com.yves.annotation.ormframe.annotation.FruitProvider;

public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {

        String strFruitName = " 水果名称：";
        String strFruitColor = " 水果颜色：";
        String strFruitProvicer = "供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);

                System.out.println(fruitName.yves());

                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor
                        + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field
                        .getAnnotation(FruitProvider.class);
                strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称："
                        + fruitProvider.name() + " 供应商地址："
                        + fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}