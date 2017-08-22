/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-8-7 下午4:06:46   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.exception;

/**
 * 自定义异常类一般都继承Exception
 * 
 * Exception extends Throwable
 * 
 * @author Yves He
 * 
 */
public class InfraException extends Exception {

    private static final long serialVersionUID = 1L;

    /* 自定义异常--构造方法 */
    public InfraException() {
        super();
    }

    public InfraException(String message) {
        super(message);
    }

    public InfraException(Throwable cause) {
        super(cause);
    }

    public InfraException(String message, Throwable cause) {
        super(message, cause);
    }
}
