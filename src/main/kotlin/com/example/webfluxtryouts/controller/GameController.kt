package com.example.webfluxtryouts.controller

import com.example.webfluxtryouts.repository.NewGame
import com.example.webfluxtryouts.repository.NewGameRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.*

@RestController("/game")
class GameController(
    val newGameRepository: NewGameRepository
) {

    @PostMapping("/create")
    fun createGame(@RequestBody newGame: NewGame): Mono<NewGame> {
        val newGame = NewGame(
            name = UUID.randomUUID().toString(),
            newGameId = UUID.randomUUID().toString(),
            playerCount = 2
        )

        return newGameRepository.save(newGame)
    }

    @GetMapping("/{gameId}")
    fun getGame(@PathVariable gameId: String): Mono<NewGame> {
        return newGameRepository.findByNewGameId(gameId).flatMap {
            it.name = "some-game"
            newGameRepository.save(it)
        }
    }
}