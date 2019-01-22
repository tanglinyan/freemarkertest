package net.se.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerDemo {
    private static final String TEMPLATE_PATH = "src/main/java/net/se/templates";
    private static final String CLASS_PATH = "src/main/java/net/se/templates/";

    public static void main(String[] args){
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        // setp2 设置默认编码
        configuration.setDefaultEncoding("UTF-8");
        Writer out = null;
        try {
            // setep3 指定模板URI
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            //setep4 读取模板
            Template template = configuration.getTemplate("Demo.ftl");
            File docFile = new File(CLASS_PATH,"Demo.java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            Map<String, Object> dataModel = dataModelBuilder();
            //setep 5 生成模板
            template.process(dataModel,out);
            System.out.println("===========================>>> 生成成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    /**
     * 构造数据模型
     * dataModel key必须为String类型
     * **/
    public final static Map<String,Object> dataModelBuilder(){
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("className","Demo");
        dataMap.put("classPath","net.se.templates");
        dataMap.put("outInfo","---------程序结束---------");
        dataMap.put("objectFlag",null);
        dataMap.put("pagePath","net.se.freemarker");
        dataMap.put("objectName","User");
        dataMap.put("exampleObjectName","user");
        /**
         * 用户对象
         * **/
        User user = new User();
        user.setName("小明");
        //user.setPassword("123456");
        user.setLastTime("2019-1-15");
        User user2 = new User();
        user2.setName("小红");
        user2.setPassword("123456");
        //user2.setLastTime("2019-1-15");
        User user3 = new User();
        user3.setName("小亮");
        //user3.setPassword("123456");
        user3.setLastTime("2019-1-15");

        dataMap.put("user",user);
        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user2);
        list.add(user3);
        dataMap.put("userList",list);

        dataMap.put("sayInfo","hi,I like the code");

        Map<String,String> map = new HashMap<String,String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        dataMap.put("testMap",map);
        return dataMap;
    }
}
