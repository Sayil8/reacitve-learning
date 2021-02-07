package com.reactive.learning.controller

import com.reactive.learning.model.Purchase
import com.reactive.learning.service.CoinBaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime

class PurchaseHandler {

    @Autowired
    lateinit var coinBaseService: CoinBaseService

    fun listPurchases(serverRequest: ServerRequest) :Mono<ServerResponse> {
        val purchase: Mono<Purchase> = coinBaseService.getPurchaseById(serverRequest.pathVariable("id"))
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(purchase, purchase.javaClass)
    }

    fun listAllPurchases() : Mono<ServerResponse> {
        val purchases : Flux<Purchase> = coinBaseService.listAllPurchases()
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(purchases.collectList(), purchases.javaClass)
    }
}