package com.dwg;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.Collections;

public class MybatisPlusGeneratorTest {
    private final String projectPath = System.getProperty("user.dir");
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG =
            new DataSourceConfig.Builder(
                    "jdbc:mysql://localhost:3306/lc_order?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    "123456")
                    .dbQuery(new MySqlQuery())
                    .typeConvert(new MySqlTypeConvert());

    @Test
    public void Generator() {
        FastAutoGenerator
                .create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder -> {
                    System.out.println("全局配置");
                    builder
                            .author("Autrui")
                            .disableOpenDir()
                            .enableSwagger()
                            .outputDir(projectPath + "/src/main/java")
                            .commentDate("yyyy-MM-dd");
                })
                // 包配置
                .packageConfig(builder -> {
                    System.out.println("包配置");
                    builder
                            .parent("com.dwg")
                            // .moduleName("")
                            .controller("controller")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.serviceImpl")
                            .mapper("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper"));
                })
                // 策略配置
                .strategyConfig(builder -> {
                    System.out.println("策略配置");
                    builder
                            .addInclude("tb_order") // 设置需要生成的表名
                            .addTablePrefix("tb_") // 设置过滤表前缀
                            .serviceBuilder() // 开启service策略配置
                            .formatServiceFileName("%sService") // 取消Service前的I
                            .formatServiceImplFileName("%sServiceImpl")
                            .controllerBuilder() // 开启controller策略配置
                            .enableRestStyle() // 配置restful风格
                            .enableHyphenStyle() // url中驼峰转连字符
                            .entityBuilder() // 开启实体类配置
                            .enableLombok() // 开启lombok
                            .logicDeleteColumnName("deleted") //说明删除逻辑是哪个字段
                            .enableTableFieldAnnotation() // 属性加上说明注解
                            .enableChainModel() // 开启lombok链式操作
                            .enableRemoveIsPrefix(); // 开启 Boolean 类型字段移除 is 前缀
                })
                .templateConfig(builder ->
                        // 实体类使用我们自定义模板
                        builder.entity("templates/MyEntity.java")
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
