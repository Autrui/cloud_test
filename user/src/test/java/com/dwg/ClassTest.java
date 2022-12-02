package com.dwg;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

public class ClassTest {
    private String projectPath = System.getProperty("user.dir");
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG =
            new DataSourceConfig.Builder(
                    "jdbc:mysql://localhost:3306/lc_user?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    "123456")
                    .dbQuery(new MySqlQuery())
                    .typeConvert(new MySqlTypeConvert());
    @Test
    public  void test1(){
        System.out.println(projectPath);
    }

    @Test
    public void test() {
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("Autrui")
                            .disableOpenDir()
                            .enableSwagger()
                            .outputDir(projectPath + "/src/main/java")
                            .commentDate("yyyy-MM-dd");
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.dwg")
                            .controller("controller")
                            .entity("entity")
                            .service("service")
                            .mapper("mapper")
                            .xml("mapper.");
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder
                            .addInclude("tb_user") // 设置需要生成的表名
                            .addTablePrefix("tb_") // 设置过滤表前缀
                            .serviceBuilder() // 开启service策略配置
                            .formatServiceFileName("%sService") // 取消Service前的I
                            .controllerBuilder() // 开启controller策略配置
                            .enableRestStyle() // 配置restful风格
                            .enableHyphenStyle() // url中驼峰转连字符
                            .entityBuilder() // 开启实体类配置
                            .enableLombok() // 开启lombok
                            .enableChainModel() // 开启lombok链式操作
                            .enableRemoveIsPrefix(); // 开启 Boolean 类型字段移除 is 前缀
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
