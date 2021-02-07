package com.reactive.learning.controller

import com.reactive.learning.model.Purchase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class PurchaseControllerTest {

    @Autowired
    lateinit var  context : ApplicationContext

    lateinit var webTestClient : WebTestClient

    @BeforeEach
    fun setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(context).build()
    }

    @Test
    fun createPurchase() {
        webTestClient.get()
                .uri("coin/purchase/v1/{id}", 123)
                .exchange()
                .expectStatus().isNotFound
                .expectBody(Purchase::class.java)
    }
}