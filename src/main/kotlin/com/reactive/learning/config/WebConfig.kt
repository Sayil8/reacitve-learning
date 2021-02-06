package com.reactive.learning.config

import com.reactive.learning.controller.PurchaseHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.*

@Configuration
@EnableWebFlux
class WebConfig : WebFluxConfigurer {

    @Bean
    fun PurchaseHandler(): PurchaseHandler {
        return com.reactive.learning.controller.PurchaseHandler()
    }

    @Bean
    fun routerFunctionPurchase(purchaseHandler: PurchaseHandler) : RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.GET("/coin/purchase/v1/{name}")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), purchaseHandler::listPurchases
        )
    }

}