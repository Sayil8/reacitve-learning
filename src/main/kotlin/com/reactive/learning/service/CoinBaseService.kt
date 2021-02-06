package com.reactive.learning.service

import com.reactive.learning.model.CoinBaseResponse
import com.reactive.learning.model.Purchase
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CoinBaseService {

    fun getCryptoPrice(priceName: String) :Mono<CoinBaseResponse>

    fun createPurchase(priceName: String) : Mono<Purchase>

    fun getPurchaseById(id : String) : Mono<Purchase>

    fun listAllPurchases() :Flux<Purchase>
}