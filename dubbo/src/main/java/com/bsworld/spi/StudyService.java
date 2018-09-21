package com.bsworld.spi;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/*
*author: xieziyang
*date: 2018/5/6
*time: 23:32
*description:
*/
@SPI("chinese")
public interface StudyService {
    void hello(String study);
    @Adaptive
    void adaptiveHello();
}
