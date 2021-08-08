package com.hezhenguang.developtoolsplatform.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


/**
 * @author 登高而望远
 */
@Configuration
@PropertySource("classpath:config.application-jdbc.yml")
public class DruidConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.bop92")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.bop92", name = "enabled", havingValue = "true")
    public DataSource druidConfigForBop92() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.bop102")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.bop92", name = "enabled", havingValue = "true")
    public DataSource druidConfigForBop102() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.aliyun")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.bop92", name = "enabled", havingValue = "true")
    public DataSource druidConfigForAliyun() {
        return DataSourceBuilder.create().build();
    }
}