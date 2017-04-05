/**   
 * Filename:    TestProcess.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-27 下午5:39:48   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.thread.threadpoolexecutor;

import java.io.IOException;

public class TestProcess {
    public static void main(String[] args) throws IOException,
            InterruptedException {
        Runtime runtime = Runtime.getRuntime();

        Process exec = runtime.exec(".//cmd.exe");
        exec.waitFor();

    }
}