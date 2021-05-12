package com.example.webfluxtryouts.controller

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("prototype")
class SomeComp {

    var someValue: String = "1"
}