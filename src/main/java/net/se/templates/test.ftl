package ${classPath};

public class ${className} {

    public static void main(String[] args) {
        <#list printList as print>
            <#if print??>
                //is null
            <#else>
                //not null
            </#if>
            System.out.println("hell word ${print_index}");
        </#list>
        <#list testMap?keys as key>
            <#if testMap[key]??>
                //${key} > ${testMap[key] ? default("null")}
            <#else>
                //${key} > 我等于null
                <#-- ? default("null")-->
            </#if>
        </#list>
        <#if method == "1">
            System.out.println("-------生产模式-------");
        <#elseif method == "0">
            System.out.println("-------开发模式-------");
        </#if>
        <#include "index.html">
        //${now?date}
        //${now?time}
        //${now?datetime}
        //${now?string("yyyy/MM/dd HH:mm:ss")}
        <@content name="chenghui" age="120">
          	${output}
          	${append}
          </@content>
          <#assign user = jsonObject?eval>
          //jsonObject > ${jsonObject}
          //User name :> ${user.name}
          <#assign tempTest = testNull!>
          //${tempTest}
          <#if (testNull!"")??>
                //is null
          </#if>
    }

}