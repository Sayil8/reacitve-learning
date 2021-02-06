package com.reactive.learning.controller

import com.reactive.learning.model.Purchase
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.time.LocalDateTime

class PurchaseHandler {

    fun listPurchases(serverRequest: ServerRequest) :Mono<ServerResponse> {
        val purchase: Mono<Purchase> = Mono.fromSupplier { Purchase("From functional endpoint", "12.99", LocalDateTime.now()) }
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(purchase, purchase.javaClass)
    }
}