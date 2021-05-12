package com.example.webfluxtryouts.controller

import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

class BeansController(
    val applicationContext: ApplicationContext,
    val someComp: SomeComp
) {

    @GetMapping("/beans")
    fun beans(): String {
        someComp.someValue = "2"
        return someComp.someValue
    }

    @GetMapping("/getAllBeans")
    fun allBeans(): String {
        return applicationContext.getBean("mySampleObject").toString()
    }
}