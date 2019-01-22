package net.se.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 最常见的问题：
 * java.io.FileNotFoundException: xxx does not exist. 解决方法：要有耐心
 * FreeMarker jar 最新的版本（2.3.23）提示 Configuration 方法被弃用
 * 代码自动生产基本原理：
 * 数据填充 freeMarker 占位符
 */
public class FreeMarkerDemo2 {

    private static final String TEMPLATE_PATH = "src/main/java/net/se/templates";
    private static final String CLASS_PATH = "src/main/java/net/se/templates/";

    public static void main(String[] args) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            configuration.setDefaultEncoding("UTF-8");
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("classPath", "net.se.templates");
            dataMap.put("className", "AutoCodeDemo");
            // step4 加载模版文件
            Template template = configuration.getTemplate("test.ftl");
            // step5 生成数据
            File docFile = new File(CLASS_PATH + "\\" + "AutoCodeDemo.java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^AutoCodeDemo.java 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                    out.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
