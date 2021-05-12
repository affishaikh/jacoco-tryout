package com.example.webfluxtryouts

import org.junit.jupiter.api.Test

class DiffTest {
    val javers =

    @Test
    fun diff() {
        val p = Person(name = "", email = "", phone = "")
        val p1 = Person(name = "", email = "", phone = "")


    }
}

data class Person(
    val name: String,
    val email: String,
    val phone: String
)