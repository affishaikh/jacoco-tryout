package com.example.webfluxtryouts.controller

import com.example.webfluxtryouts.beans.MySampleObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BeansController2(val someComp: SomeComp) {

    @GetMapping("/beans2")
    fun beans(): String {
        return someComp.someValue
    }
}