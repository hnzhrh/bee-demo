package com.hnzhrh.bee.domain.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;



/**
 * @author lichennan
 * @since 2021年10月24日 16:52
 */

public class CodeGenerator {
    public static final String url = "jdbc:mysql://47.98.51.143:3306/bank?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String user = "root";
    public static final String password = "hnzhrh,1996";

    private static final String projectPath = System.getProperty("user.dir");
    // 数据源配置
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(url, user, password)
            .typeConvert(new MySqlTypeConvert());

    public static void main(String[] args) {
        FastAutoGenerator
                .create(DATA_SOURCE_CONFIG)
                //全局配置
                .globalConfig(builder -> {
                    builder.author("erpang") // 设置作者
                            // .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir() // 执行完毕不打开文件夹
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/domain/" + "/src/main/java"); // 指定输出目录
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("com.hnzhrh.bee.domain") // 设置父包名
                            .entity("entity") //生成实体层
                            .mapper("mapper"); //生成mapper层
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("market_quote") // 设置需要生成的表名
                            .addTablePrefix("tbl_")// 设置过滤表前缀
                            .serviceBuilder() //开启service策略配置
                            .formatServiceFileName("%sService") //取消Service前的I
                            .controllerBuilder() //开启controller策略配置
                            .enableRestStyle() //配置restful风格
                            .enableHyphenStyle() //url中驼峰转连字符
                            .entityBuilder() //开启实体类配置
                            .enableLombok() //开启lombok
                            .enableChainModel(); //开启lombok链式操作

                })
                //模板配置
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                //执行
                .execute();
    }

}