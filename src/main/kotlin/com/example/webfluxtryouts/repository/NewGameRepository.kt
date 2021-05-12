package com.example.webfluxtryouts.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface NewGameRepository: ReactiveCrudRepository<NewGame, String> {

    fun findByNewGameId(id: String): Mono<NewGame>
}