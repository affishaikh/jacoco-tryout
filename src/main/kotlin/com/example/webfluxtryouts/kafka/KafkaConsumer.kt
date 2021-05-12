package com.example.webfluxtryouts.kafka

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.IntegerDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.kafka.receiver.KafkaReceiver
import reactor.kafka.receiver.ReceiverOptions
import reactor.kafka.receiver.ReceiverRecord
import java.util.*
import javax.annotation.PostConstruct

//@Component
class KafkaConsumer {

    @PostConstruct
    fun connectToTopic() {
        val consumerProps: MutableMap<String, Any> = HashMap()
        consumerProps[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "http://localhost:9092"
        consumerProps[ConsumerConfig.GROUP_ID_CONFIG] = "sample-group"
        consumerProps[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = IntegerDeserializer::class.java
        consumerProps[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java

        val receiverOptions = ReceiverOptions.create<String, String>(consumerProps)
            .subscription(setOf("learning-kafka"))

        val inboundFlux: Flux<ReceiverRecord<String, String>> = KafkaReceiver.create<String, String>(receiverOptions)
            .receive()

        inboundFlux.subscribe {
            println("Received Data\n$it")
        }
    }
}