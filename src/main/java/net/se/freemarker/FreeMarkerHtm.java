package net.se.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerHtm {
    private static final String TEMPLATE_PATH = "src/main/java/net/se/templates";
    private static final String CLASS_PATH = "src/main/java/net/se/templates/";

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
        Writer out = null;
        try {
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            Template template = configuration.getTemplate("htm.ftl");
            Map<String, Object> dataModel = dataModelBuilder();
            File docFile = new File(CLASS_PATH,"Demo.html");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            template.process(dataModel,out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    public static Map<String,Object> dataModelBuilder(){
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("title","hell word");
        return dataMap;
    }
}
