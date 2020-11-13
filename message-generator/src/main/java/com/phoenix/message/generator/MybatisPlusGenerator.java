package com.phoenix.message.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MybatisPlusGenerator {

    public static void main(String[] args) {
        String databaseUrl = "jdbc:mysql://127.0.0.1:3306/phoenix?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B0&allowPublicKeyRetrieval=true&useSSL=false";
        String databaseUsername = "root";
        String databasePassword = "root";
        String[] tables = {"task_config"};

        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        config.setActiveRecord(true)
                .setAuthor("nome")
                .setOutputDir(projectPath + "/message-common/src/main/java")
                .setFileOverride(true)
                .setOpen(false)
                .setSwagger2(true)
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();

        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl(databaseUrl)
                .setUsername(databaseUsername)
                .setPassword(databasePassword);
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //.setTablePrefix("表名前缀")
                //.setSuperEntityClass("父类")
                //.setSuperControllerClass("父类")
                .setRestControllerStyle(true)
                .setEntityLombokModel(true)
                .setEntityColumnConstant(true)
                .setChainModel(true)
                .setInclude(tables);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.phoenix.message.common")
                .setController("controller")
                .setService("service")
                .setMapper("mapper")
                .setXml("mapper")
                .setEntity("entity");

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        autoGenerator.execute();
    }

}