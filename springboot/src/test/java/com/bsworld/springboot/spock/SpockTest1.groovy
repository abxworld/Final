package com.bsworld.springboot.spock

import com.bsworld.springboot.spock.origin.HalfSearch
import spock.lang.Specification
import spock.lang.Unroll

/**
 * program: Final 
 * author: bsworld.xie 
 * create: 2019-10-03 22:30 
 * description: 
 */
class SpockTest1 extends Specification {

    def "test half find"() {
        expect:
        HalfSearch.search(arr as int[], key) == result
        where:
        arr       | key | result
        []        | 1   | -1
        [1, 2, 9] | 9   | 3
        [1, 2, 9] | 3   | 0
    }

    @Unroll
    def "test new half find"() {
        expect:
        HalfSearch.search(arr as int[], key) == result
        where:
        arr             | key | result
        []              | 10  | -1
        [1, 2, 3, 4, 5] | 3   | 1
        [1, 2, 3, 4, 7] | 4   | 1
    }


}
