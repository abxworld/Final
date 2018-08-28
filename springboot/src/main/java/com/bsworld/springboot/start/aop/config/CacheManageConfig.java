package com.bsworld.springboot.start.aop.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilderSpec;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

/*
*author: xieziyang
*date: 2018/7/10
*time: 20:25
*description:
*/
@Configuration
public class CacheManageConfig {

    @Bean(value = "cacheBuilder")
    public CacheBuilder CacheBuilderBean() {
        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().expireAfterWrite(24, TimeUnit.HOURS).maximumSize(100);
        return builder;
    }

    @DependsOn("cacheBuilder")
    @Bean("guavaCacheManager")
    @Primary
    public GuavaCacheManager GuavaCacheManagerBean(CacheBuilder<Object, Object> cacheBuilder) {
        GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
        guavaCacheManager.setCacheBuilder(cacheBuilder);
        //guavaCacheManager.setAllowNullValues(true);
        return guavaCacheManager;
    }
}
