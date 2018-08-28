package com.bsworld.springboot.start.config.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
*author: xieziyang
*date: 2018/7/23
*time: 16:49
*description:
*/
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.bsworld.springboot.start.dao.mapper",sqlSessionFactoryRef =  "sqlSessionFactory")
public class MysqlConfig {

    @Bean(name = "druidDateSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {
        return new com.alibaba.druid.pool.DruidDataSource();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setConfigLocation(resolver.getResource("META-INF/mybatis/mybatis-config.xml"));
        factory.setMapperLocations(resolver.getResources("META-INF/mybatis/mapper/*Mapper.xml"));
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DruidDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}
