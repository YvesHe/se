package cn.com.yves.string.string;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * 测试 String 中的一些方法,比较简单的方法就省略了测试
 * 
 * @author Yves He
 * 
 */
public class TestString {

    public static void main(String[] args) {

        // reload();
        // testGetChar();

        // testEncode();

        // testPoint();
        // testToLower();

        // testIntern();

        testEquals();
    }

    public static void testGetChar() {// 将字符串指定的子串写进char[]数组中
        String message = "hello";
        char[] result = new char[20];
        message.getChars(1, 5, result, 0);

        System.out.println(new String(result, 0, 4));

    }

    // String +操作原理
    public static void reload() {
        String string = "hollis";
        String string2 = (new StringBuilder(String.valueOf(string))).append(
                "chuang").toString();
        String string3 = string + "chuang";
        System.out.println(string2.equals(string3));
    }

    public static void testEncode() {// 验证 编码和解码
                                     // 结论:
                                     // 如果字符串中有中文一定要在编码的时候指定能支持中文的编码EG:UTF-8;GB2312;gbk
                                     // (也就是在得到byte[]的时候指定编码),然后解码的时候指定编码的时候的编码就可以正确解码

        // 特别注意的是: bgk 和UTF-8之间是不能互相转换的.

        String message = "yves你好";

        try {
            byte[] result = message.getBytes("UTF-8");// ISO-8859-1 GB2312
                                                      // UTF-8
            System.out.println(new String(result, "UTF-8"));// 显示正确
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static void testPoint() {// index - char 值的索引,返回该char值的ASCII值
        String message = "abc你好";
        System.out.println(message.codePointAt(0));// a=97
        System.out.println(message.codePointBefore(1));// 97 返回指定索引之前的字符（Unicode
                                                       // 代码点）。

        System.out.println(message.offsetByCodePoints(0, 5));
    }

    public static void testToLower() {
        String message = "aBcD你好";
        String lowerCase = message.toLowerCase(Locale.ENGLISH);
        System.out.println(lowerCase);

        System.out.println(Locale.getDefault().getCountry());// CN

    }

    public static void testIntern() {// intern native方法
        /* 它遵循以下规则：对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时， */
        /* s.intern() == t.intern() 才为 true。 */
        /* (PS:也就是说只要值相等的时候,intern()方法就能取到第一次存放在字符串池中的值.) */

        String message = "yves";
        String intern = message.intern();
        System.out.println(intern);
    }

    public static void testEquals() {
        String s1 = "a";
        String s2 = "b";

        String s3 = "ab";// 在字符串池中先存只有一份(存在常量池中)
        String s4 = "ab";
        String s5 = "a" + "b"; // 前端编译的时候就已经算好了 等价于 String s5="ab"; 存在常量池中.
        String s7 = s1 + s2; // 原理:用new StringBuilder().append().toString();
                             // 方法来构造的 String(存放在heap中)
        String s6 = new String("ab");// 构造方法api解释的很明确是返回一个副本(Arrays.copyOfRange来复制的),所以引用是不相同的.

        System.out.println(s3 == s4);// true
        System.out.println(s3.equals(s4));// true
                                          // //重写的equals方法里面已经和明确是先比较引用,然后对char[]数组的值进行了比较.

        System.out.println(s3.equals(s6));// true 先比较引用,后比较了值
        System.out.println(s6.equals(s7) && s5.equals(s7));// true

        System.out.println(s3 == s5);// true
        System.out.println(s5 == s7);// false
        System.out.println(s3 == s7);// false
        System.out.println(s4.intern() == s3 && s4.intern() == s3.intern());// true
        System.out.println(s7.intern() == s3.intern());// true 见testIntern()方法

    }

    // 唯一没弄懂的两个方法 1. offsetByCodePoints(int index, int codePointOffset)

    // 2. codePointCount(int beginIndex, int endIndex)

    // 3. codePointAt(int index) 返回的ascii编码 : a=97
}
