package com.reactive.learning.controller

import com.reactive.learning.model.CoinBaseResponse
import com.reactive.learning.service.CoinBaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/coin/price/v1")
class PriceController {

    @Autowired
    lateinit var coinBaseService: CoinBaseService

    @GetMapping("/{name}")
    fun getPrice(@PathVariable name: String) :Mono<CoinBaseResponse> {
        return coinBaseService.getCryptoPrice(name)
    }

}