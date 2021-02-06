package com.reactive.learning.controller

import com.reactive.learning.model.Purchase
import com.reactive.learning.service.CoinBaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@RestController
@RequestMapping("/coin/purchase/v1")
class PurchaseController {

    @Autowired
    lateinit var coinBaseService: CoinBaseService

    @PostMapping("/{name}")
    fun createPurchase(@PathVariable name: String) : Mono<Purchase>
    {
        return coinBaseService.createPurchase(name)
    }
}