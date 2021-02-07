package com.reactive.learning.service

import com.reactive.learning.model.CoinBaseResponse
import com.reactive.learning.model.Purchase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Service
class CoinBaseServieImp : CoinBaseService {

    @Autowired
    lateinit var webClient : WebClient

    @Autowired
    lateinit var reactiveMongoTemplate: ReactiveMongoOperations

    override fun getCryptoPrice(priceName: String): Mono<CoinBaseResponse> {
        return webClient.get()
                .uri("https://api.coinbase.com/v2/prices/{crypto}/buy", priceName)
                .exchange()
                .flatMap {
                    it.bodyToMono(CoinBaseResponse::class.java)
                }
    }

    override fun createPurchase(priceName: String): Mono<Purchase> {
        return getCryptoPrice(priceName).flatMap { coinBaseResponse ->
            reactiveMongoTemplate.save(Purchase(priceName, coinBaseResponse.data.amount, LocalDateTime.now()))
        }
    }

    override fun getPurchaseById(id: String): Mono<Purchase> {
        return reactiveMongoTemplate.findById(id, Purchase::class.java)
    }

    override fun listAllPurchases(): Flux<Purchase> {
        return reactiveMongoTemplate.findAll(Purchase::class.java)
    }
}