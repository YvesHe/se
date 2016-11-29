/**   
 * Filename:    A.java   
 * Copyright:   Copyright (c)2010  
 * Company:     dreams8 
 * @version:    1.0   
 * @since:  JDK 1.7
 * Create at:   2016-11-29 下午2:39:54   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2016-11-29 Yves He      1.0     1.0 Version   
 */
package cn.com.yves.generic;

import java.util.Enumeration;
import java.util.List;

public class EnumImpl<E> implements Enumeration<E> {
    private final List<E> list;

    public EnumImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasMoreElements() {

        if (this.list == null) {
            return false;
        }

        return this.list.size() > 0;
    }

    @Override
    public E nextElement() {
        if (this.list.size() == 0) {
            return null;
        }
        E result = this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);

        return result;
    }
}
