/**   
 * Filename:    TestMatcher.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-4-5 上午11:45:58   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.regexp;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试Matcher *
 * 
 * 
 * 此类的实例用于多个并发线程是不安全的。
 * 
 * @author Yves He
 * 
 */
public class TestMatcher {
    public static void main(String[] args) {
        // testPatter();

        // testMatcher();
        // testLookingAt();
        // testFind();

        // testGroupCount();
        // testSart();

        // testReset();

        // testResetParameter();

        // testToString();

        // testUsePattern();
        // testHitEnd();

        // testRegion();
        // testRegionStart();

        // testQuoteReplacementStatic();// 特殊字符的字面量

        testRepalceFirst();

    }

    public static void testPatter() {// 返回此匹配器解释的模式。

        Pattern pattern = Pattern.compile("yves");
        Matcher matcher = pattern.matcher("yves10010");

        Pattern sourcePattern = matcher.pattern();
        System.out.println(sourcePattern == pattern);// true

    }

    public static void testToMatcherResult() {// 注意:Matcher 实现了接口MatchResult
        Pattern pattern = Pattern.compile("yves");
        Matcher matcher = pattern.matcher("yves10010");

        MatchResult matchResult = matcher.toMatchResult();// 返回的是接口MatchResult的引用,这个方法是底层是通过clone方法返回的.所以该结果不受对此匹配器执行的后续操作的影响。
                                                          // 也就是说,后续对matcher的操作,不会影响matchResult的值.
    }

    public static void TestUsePattern() {
        // to to
    }

    public static void testReset() {// 重置匹配器:两个重载方法reset() 重置匹配器
        Pattern pattern = Pattern.compile("yves\\d*");
        Matcher matcher = pattern.matcher("yves11yves22yves33");

        matcher.find();
        System.out.println(matcher.group());// yves11

        matcher.find();
        System.out.println(matcher.group()); // yves22

        /* 如果不进行重置的话 再次执行上面的两句结果应该是 yves33 */
        Matcher reset = matcher.reset();// 重置之后:重置匹配器将放弃其所有显式状态信息并将其添加位置设置为零。匹配器的区域被设置为默认区域，默认区域就是其整个字符序列。
                                        // 返回的应用对此昂reset实质还是原来的matcher对象,并没有产生新对象.
        matcher.find();
        System.out.println(matcher.group()); // yves11

        reset.find();
        System.out.println(reset.group());// yves22

    }

    public static void testResetParameter() {// 重置匹配器:两个重载方法reset() 重置匹配器
        Pattern pattern = Pattern.compile("yves\\d*");
        Matcher matcher = pattern.matcher("yves11yves22yves33");

        matcher.find();
        System.out.println(matcher.group());// yves11

        matcher.find();
        System.out.println(matcher.group()); // yves22

        matcher.reset("abc11abc22abc33");// 将matcher的text变量换成参数中的,然后重置了reset()方法重置.

        matcher.find();// false 此时换了要匹配的字符串,就匹配不到yves\\d*了

    }

    public static void testMatcher() {// 是完全匹配
        Pattern pattern = Pattern.compile("yves");
        Matcher matcher = pattern.matcher("yves");// 如果是yves22yves33yves將匹配不到
        if (matcher.matches()) {
            System.out.println(matcher.group());// yves
        }
    }

    public static void testLookingAt() {// 当且仅当输入序列的前缀匹配此匹配器的模式时才返回 true。不需要完全匹配
        Pattern pattern = Pattern.compile("yves\\d*");
        Matcher matcher = pattern.matcher("yves22yves33yves");
        if (matcher.lookingAt()) {

            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();

            System.out.print(start + "\t");
            System.out.print(end + "\t");
            System.out.println(group); // yves22
        }
    }

    public static void testFind() {// 两个方法重载 : find(int start) 和find()
        Pattern pattern = Pattern.compile("yves");
        Matcher matcher = pattern.matcher("yves22yves33yves");

        matcher.find(6);// 先重置后,再从字符串下标为6的地方开始查找,刚好是第二个y字母,此时找到的结果为yves33

        while (matcher.find()) {// matcher.find() :尝试查找与该模式匹配的输入序列的下一个子序列。

            int start = matcher.start();// 不管是第几次匹配成功,start和end的在原来字符串的位置都是相对于原字符串"yves22yves33yves"中的位置
            int end = matcher.end();
            String group = matcher.group();

            System.out.print(start + "\t");
            System.out.print(end + "\t");
            System.out.println(group);// 最后一个yves
        }
    }

    public static void testGroupCount() {
        Pattern pattern = Pattern.compile("(yves)(\\d*)");// 这里分了两个组
        Matcher matcher = pattern.matcher("yves22yves33yves");

        System.out.println(matcher.groupCount());// 分组的组数是根据 模式里面分组情况来的

    }

    public static void testSart() {// start end group
                                   // 这三个方法是类似都有两个重载,但是带参数的都是要匹配模式中有了分组才能用,否则会报错早不到组,而且组也不能越界
                                   // 在调用者三个方法之前一定要先找到了匹配项才能调用,否则会报错
                                   // java.lang.IllegalStateException: No match
                                   // found

        Pattern pattern = Pattern.compile("(yves)(\\d*)");// 这里分了两个组
        Matcher matcher = pattern.matcher("yves22yves33yves");

        while (matcher.find()) {// matcher.find() :尝试查找与该模式匹配的输入序列的下一个子序列。

            int start = matcher.start(2);// 不管是第几次匹配成功,start和end的在原来字符串的位置都是相对于原字符串"yves22yves33yves"中的位置
            int end = matcher.end(2);
            String group = matcher.group(2);

            System.out.print(start + "\t");
            System.out.print(end + "\t");// 注意不是最后一个2的下标,而是最后下标的偏移量也就是该下标+1
            System.out.println(group);// 最后一个yves
        }
    }

    public static void testToString() {
        Pattern pattern = Pattern.compile("yves\\d*");
        Matcher matcher = pattern.matcher("yves22yves33yves");

        String string = matcher.toString();
        System.out.println(string);// java.util.regex.Matcher[pattern=yves\d*
                                   // region=0,16 lastmatch=]
    }

    public static void testUsePattern() {// 使用一个新的Pattern,是的原来的pattern失效
        Pattern pattern = Pattern.compile("yves");
        Matcher matcher = pattern.matcher("yves22yves33yves");
        matcher.usePattern(Pattern.compile("yves22"));

        if (matcher.lookingAt()) {
            System.out.println(matcher.group());// yves22
        }

    }

    public static void testUseAnchoringBounds() {// 使用区域定位,才会有hasAnchoringBounds()
                                                 // 为true 默认是使用

    }

    public static void testUseTransparentBounds() {// 使用区域定位,才会有hasTransparentBounds()
                                                   // 为true 默认是使用

    }

    public static void testHitEnd() {// 当且仅当在最后匹配中遇到输入结尾时才返回 true；否则返回 false。
        Pattern pattern = Pattern.compile("yves\\d*");
        Matcher matcher = pattern.matcher("yves22yves33yves");
        while (matcher.find()) {
            if (matcher.hitEnd()) {
                System.out.println(matcher.group());// yves
            }
        }
    }

    public static void testRegion() {// 设置此匹配器的区域限制。 简单讲就是只能在这个指定的区域进行匹配
        Pattern pattern = Pattern.compile("yves\\d*");
        Matcher matcher = pattern.matcher("yves22yves33yves");// 总长度16

        int start = 0;// start - 索引，从此索引（包括在内）开始搜索。下标从0开始
        int end = 16;// end - 到此（包括在内）结束搜索的索引。 下标+1
        matcher.region(start, end);

        System.out.println(matcher.regionStart());// 0
        System.out.println(matcher.regionEnd());// 16

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void testRegionStart() {// 没有使用方法 matcher.region(start, end);是
                                          // 默认就是 0到 字符串总长度
        Pattern pattern = Pattern.compile("yves\\d*");
        Matcher matcher = pattern.matcher("yves22yves33yves");// 总长度16

        System.out.println(matcher.regionStart());// 0
        System.out.println(matcher.regionEnd());// 16
    }

    public static void testQuoteReplacementStatic() {// ?
        String quoteReplacement = Matcher.quoteReplacement("\\$");
        System.out.println(quoteReplacement);// \\\$

        String quote = Pattern.quote("\\$");// 这中字面的用途是用在匹配查找
        System.out.println(quote);// \Q\$\E

    }

    public static void testRepalceFirst() {// replaceFirst：替换第一个匹配正则规则的子序列
                                           // replaceAll：替换所有匹配正则规则的子序列。

        String quoteReplacement = Matcher.quoteReplacement("\\$");// 生成字面量,用于替换
        System.out.println(quoteReplacement);// \\\$

        Pattern pattern = Pattern.compile("yves\\d*");
        Matcher matcher = pattern.matcher("yves22yves33yves");

        String result = matcher.replaceFirst(quoteReplacement); // 如果在使用的时候需要替换的是结果为
                                                                // (若果是是直接写\\\$会报错)
                                                                // \$yves33yves,这里就要用到字面量了,主要是美元符和反斜杠的特殊性
        System.out.println(result);// \$yves33yves

    }

    public static void testAppendReplacement() {

    }

    public static void testAppendTail() {

    }
}
