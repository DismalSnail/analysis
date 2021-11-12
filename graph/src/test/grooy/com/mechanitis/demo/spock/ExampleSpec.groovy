package com.mechanitis.demo.spock

import spock.lang.Specification

class ExampleSpec extends Specification{
    def "should be a simple assertion"(){
        expect:
        1 == 0
    }
}
