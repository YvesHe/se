/**   
 * Filename:    SuperInterface.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-12-1 下午3:08:53   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-12-1 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.reflect.field_;

public interface SuperInterface { /*
                                   * 接口中的字段只能是public 不写修饰: 默认为public static
                                   * ,写也只能写public,而且字段要赋值.
                                   */

    // 以下定义会报错,访问权限只能是public//
    // private int namePrivateSuperInterface = 88;
    // protected int nameProtectedSuperInterface = 77;

    String nameSuperInterface = "nihao";// 简写: 默认为public static String
                                        // nameSuperInterface = "nihao";

    public final int namePublicSuperInterface = 66;
}
