package com.reactive.learning.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/coin/price/v1")
class PriceController {

    @GetMapping("/{name}")
    fun getPrice(@PathVariable name: String) :Mono<String> {
        return Mono.fromSupplier { "price" }
    }

}