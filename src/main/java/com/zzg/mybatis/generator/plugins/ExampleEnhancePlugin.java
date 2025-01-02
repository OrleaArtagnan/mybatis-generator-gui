package com.zzg.mybatis.generator.plugins;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * Example 功能增强
 * todo：增加 selectByPrimaryKeys
 * todo：Criteria 传参支持 Collection 和 数组
 * todo：模糊查询 like 增强
 *
 * @author OrleaArtagnan on 2024/7/2.
 */
public class ExampleEnhancePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }


    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }
}
