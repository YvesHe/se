/**   
 * Filename:    TestPattern.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-3-31 上午9:59:23   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

    public static void main(String[] args) {
        // testComplite();

        // testStaticMatcher();

        // testFlag();

        testStaticQuote();
    }

    // Pattern的构造方法是private,compile()是用来产生实例化对象的
    public static void testComplite() {// compile()方法有两个重载,第二个参数int
                                       // flag标致主要是用来编译匹配模式的规范,比如CASE_INSENSITIVE是编译匹配模式不区分大小写的.
        String regex = "yves";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);// Pattern.compile(regex,0)等价Pattern.compile(regex);

        System.out.println(pattern.pattern());// pattern.pattern()该方法不管flag参数为何值,还依然是之前编译后的值

        Matcher matcher = pattern.matcher("y v e s");

        boolean result = matcher.find();

        System.out.println(result);

    }

    public static void testStaticMatcher() {
        String regex = "\\w+";
        String input = "yves";
        boolean matches = Pattern.matches(regex, input);// 只适用于一次性的匹配,看是否完全匹配.
                                                        // 与Pattern.compile(regex).matcher(input).matches()的行为完全相同。
        System.out.println(matches);
    }

    public static void testFlag() {

        String regex = "\\w";
        Pattern pattern = Pattern.compile(regex, 0);

        System.out.println(pattern.flags());// 0
    }

    public static void testStaticQuote() {

        String quote = Pattern.quote("\\w*");
        System.out.println(quote);

        Pattern pattern = Pattern.compile(quote);
        Matcher matcher1 = pattern.matcher("yves");
        Matcher matcher2 = pattern.matcher("\\w*");

        boolean find1 = matcher1.find();
        boolean find2 = matcher2.find();
        System.out.println(find1);// false
        System.out.println(find2);// true

    }
}
