/**   
 * Filename:    ParseXML_XPath.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-12-4 上午11:32:29   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.xml.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

/**
 * XPath主要用来解析xml时对节点的快速搜索
 * 
 * @author Yves He
 * 
 */
public class ParseXML_XPath {

    public static void main(String[] args) {

        SAXBuilder saxBuilder = new SAXBuilder();// 跟读xml文件相关的类
        InputStream in = null;
        Document doc = null;

        try {
            in = new FileInputStream(new File("files/xml/xpath.xml"));

            /* 1.从xml文件流从获得文档对象:Document */
            doc = saxBuilder.build(in);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /* 3.使用XPath解析xml,快速查询到节点 */
        try {
            /*
             * 创建搜索器
             * :主要是来编写创建搜索条件,用xpath在查询比普通的jdom查询会快很多,因为它可以直接遍历多层来获取满足条件的节点.
             */
            XPath xpath = XPath.newInstance("//city");// 返回根节点下所有的city节点,不过有多少层.

            List<Element> selectNodes = xpath.selectNodes(doc.getRootElement());// 查询,返回查询结果
            System.out.println(selectNodes.size());
            for (Element e : selectNodes) {
                System.out.println(e.getTextNormalize());
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        }

    }

}
