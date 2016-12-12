/**   
 * Filename:    ParseXML_JDOM.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-12-3 下午10:47:42   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.xml.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * JDom技术,类似技术还有Dom4J
 * 
 * 还可以用框架Xpath
 * 
 * Format 跟输入时格式相关的类.
 * 
 * XMLOutputter 跟输入xml文件相关的类
 * 
 * @author Yves He
 * 
 */
public class ParseXML_JDom {

    public static void main(String[] args) {
        createXMLFile();// 首先创建一个xml,本测试中之后的deleteXml()都是依赖这个创建的xml;

        // parseXML();// 普通的jdom解析xml文件.

        // deleteXml();

    }

    /**
     * 对xml中的delete操作:删除节点,删除属性,删除文本
     */
    public static void deleteXml() {
        // createXMLFile();

        SAXBuilder saxBuilder = new SAXBuilder();// 跟读xml文件相关的类
        InputStream in = null;
        Document doc = null;
        try {
            in = new FileInputStream(new File("files/xml/createXML.xml"));
            /* 1.从xml文件流从获得文档对象:Document */
            doc = saxBuilder.build(in);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* 2. 获取相应的节点,操作相应的节点,属性,文本 */
        Element root = doc.getRootElement();
        Element japan = root.getChild("japan", root.getNamespace());
        root.removeContent(japan);// 2.1删除一个节点

        List<Element> children = root.getChildren();
        List<Element> citys = children.get(0).getChildren();
        citys.get(0).removeAttribute("area", root.getNamespace());// 2.2第一个city节点的属性area

        citys.get(2).setText("");// 2.3将第三个city节点的文本清空,(原来为深圳的地方.)

        /* 3.将在内存中已经修改了的document对象,重新写入硬盘文件 */
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File("files/xml/createXML.xml"));
            // Format format = Format.getPrettyFormat();// 格式良好
            // format.setEncoding("UTF-8");// 设置编码
            XMLOutputter xmlOutputter = new XMLOutputter();// 这里不需要重新设置format格式,因为是在原来的基础上做的操作,以前的format依然有效
            xmlOutputter.output(doc, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 解析一个xml文件
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void parseXML() {
        SAXBuilder saxBuilder = new SAXBuilder();// 跟读xml文件相关的类
        InputStream in = null;
        Document doc = null;
        try {
            in = new FileInputStream(new File("files/xml/parseXml.xml"));

            /* 1.从xml文件流从获得文档对象:Document */
            doc = saxBuilder.build(in);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        }

        /* 2.获取根节点: rootElement */
        Element root = doc.getRootElement();

        /* 3.获取子节点 */
        List<Element> children = root.getChildren();// 获取root下所有的子节点(只包括下一级的china和japan)
        for (Element e : children) {
            System.out.println(e.getName());
        }

        /* 对节点的一些查询操作,查询子节点,查询属性,节点之间的文本 */
        Element china = root.getChild("china", root.getNamespace());
        Attribute chinaAtt = china.getAttribute("area", root.getNamespace());// 按属性名获取某个属性,命名空间一般就是root.getNamespace(),防止有个同名的时候冲突\
        System.out.println(chinaAtt.getName());
        int chinaaArea;
        try {
            chinaaArea = chinaAtt.getIntValue();// 当知道该属性是什么类型的值后,可以用类似的方法转化
            System.out.println(chinaaArea);
        } catch (DataConversionException e1) {
            e1.printStackTrace();
        }
        String chinaText = china.getTextNormalize();// 获取节点的文本.文本是格式化后的.
        System.out.println(chinaText);
    }

    /**
     * JAVA代码创建一个XML文件
     * 
     * @throws IOException
     */
    public static void createXMLFile() {

        Element root = new Element("country");// 创建一个根节点
        Element china = new Element("china");
        Element japan = new Element("japan");

        Element beijing = new Element("city");
        Element shanghai = new Element("city");
        Element shenzhen = new Element("city");
        beijing.setAttribute("area", "15万平方公里");// 设置节点的属性

        beijing.setText("北京1");// 设置节点的文本内容
        beijing.addContent("北京2");// 设置节点的文本内容(当参数为String时):此时效果与setText相同
        shanghai.addContent("上海");
        shenzhen.addContent("深圳");
        china.addContent(beijing);// 在该节点下添加一个子节点
        china.addContent(shanghai);
        china.addContent(shenzhen);

        root.addContent(china);// 在root节点下添加一个节点
        root.addContent(japan);

        Document doc = new Document(root);// 在内存中产生一个dom树结构

        Format format = Format.getPrettyFormat();// 生成格式良好的格式Format;
        // Format format =Format.getRawFormat();//未加工处理的xml格式,也就是内容都在同一行.
        // Format format = Format.getCompactFormat();// 生成紧凑简介的格式.
        format.setEncoding("UTF-8");// 设置输出数据的格式

        XMLOutputter outputter = new XMLOutputter(format);
        OutputStream out = null;
        try {
            out = new FileOutputStream("files/xml/createXML.xml");// 路径是相对工程
            outputter.output(doc, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 修改xml中的内容,类似删除操作
     */
    public static void upateXMLFile() {
        // 更新一个节点:如果是文本或属性，直接用方法重新设置一遍
        // 若是一个节点的替换,先删除原来的节点,创建新节点后在具体的下标位置插入既可.
        // root.addContent(index, newContent);//在具体的位置添加某个元素节点
    }
}
