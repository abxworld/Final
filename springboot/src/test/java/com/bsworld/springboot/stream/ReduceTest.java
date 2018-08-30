package com.bsworld.springboot.stream;
/*
*author: xieziyang
*date: 2018/8/29
*time: 16:31
*description:
*/

import com.bsworld.springboot.basic.MyBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceTest {
    @Test
    public void run1() {
        List<MyBean> list = new ArrayList<>();
        for (long i = 1; i < 10; i++) {

            list.add(new MyBean(String.valueOf((char) i), i));
        }
        Optional<Long> reduce = list.stream().map(m -> m.getAge()).reduce((m, n) -> m + n);
        if (reduce.isPresent()) {
            Long aLong = reduce.get();
            System.out.println(aLong);
        }
    }
}
