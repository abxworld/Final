package com.bsworld.springboot.groovy

/**
 * program: Final 
 * author: bsworld.xie 
 * create: 2019-10-05 17:00 
 * description: 
 */
class Test1 {
    static void main(String[] args) {
        def range = 0..10
//        println(range)
        def result = add(10, 100)
        println(result)
    }

    static  add(int a, int b) {
        return a + b
    }
}
