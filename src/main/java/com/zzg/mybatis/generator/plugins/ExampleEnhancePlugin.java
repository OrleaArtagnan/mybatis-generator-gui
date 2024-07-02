package com.zzg.mybatis.generator.plugins;

import org.mybatis.generator.api.PluginAdapter;

import java.util.List;

/**
 * Example 功能增强
 * todo：增加 selectByPrimaryKeys
 * todo：Criteria 传参支持 Collection 和 数组
 * todo：模糊查询 like 增强
 *
 * @author zsf on 2024/7/2.
 */
public class ExampleEnhancePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

}
