<#assign nowTime = .now?string("yyyy/MM/dd HH:mm:ss")>
package ${classPath};
<#if objectFlag ?? && objectFlag == "true" >
    import ${pagePath}.${objectName};
</#if>
/**
    @author admin
    time:${nowTime}
**/
public class ${className} {
    public static void main(String[] args) {
        <#if objectFlag ?? && objectFlag == "true" >
            ${objectName} ${exampleObjectName} = new ${objectName}("${user.name}","${user.password}","${nowTime}");
        </#if>
        System.out.println("${outInfo}");
        <#list userList as user>
            <#if user_index == 0>
            //共有{${userList?size}}
            //0||${(.globals.user.name)?default('')}||${(.globals.user.password)?default('')}||${(.globals.user.lastTime)?default('')}
            //------------------------------
             </#if>
            //${user_index+1}||${(user.name)?default("''")}||${(user.password)?default("''")}||${(user.lastTime)?default("''")}
        </#list>
    }

    <#include "saymethod.ftl">

    <#list testMap?keys as key>
        //${key} || ${(testMap[key])!}
    </#list>

}