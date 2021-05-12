package com.example.webfluxtryouts.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("org.props")
class Config {
    val maxCount: Int = 5
}
