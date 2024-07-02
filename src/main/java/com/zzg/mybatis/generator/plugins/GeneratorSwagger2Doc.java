package com.zzg.mybatis.generator.plugins;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * Project: mybatis-generator-gui
 *
 * @author zsf on 2024/7/2.
 * 给对象添加 Swagger 注解
 */
public class GeneratorSwagger2Doc extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        String classAnnotation = "@ApiModel(value=\"" + topLevelClass.getType() + "\")";
        if (!topLevelClass.getAnnotations().contains(classAnnotation))
            topLevelClass.addAnnotation(classAnnotation);
        String apiModelAnnotationPackage = this.properties.getProperty("apiModelAnnotationPackage");
        String apiModelPropertyAnnotationPackage = this.properties.getProperty("apiModelPropertyAnnotationPackage");
        if (null == apiModelAnnotationPackage)
            apiModelAnnotationPackage = "io.swagger.annotations.ApiModel";
        if (null == apiModelPropertyAnnotationPackage)
            apiModelPropertyAnnotationPackage = "io.swagger.annotations.ApiModelProperty";
        topLevelClass.addImportedType(apiModelAnnotationPackage);
        topLevelClass.addImportedType(apiModelPropertyAnnotationPackage);

        //去掉多余的空格
        String remarks = introspectedColumn.getRemarks();
        remarks = StringUtils.trim(remarks);

        field.addAnnotation("@ApiModelProperty(value=\"" + remarks + "\")");
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }
}