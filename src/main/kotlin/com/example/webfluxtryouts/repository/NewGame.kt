package com.example.webfluxtryouts.repository

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("newGame")
data class NewGame(
    @Indexed(unique = true)
    val newGameId: String,
    var name: String,
    val playerCount: Int
) {
    var _id: ObjectId? = null
}
