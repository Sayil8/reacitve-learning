package com.reactive.learning.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import org.springframework.context.annotation.Bean
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient

class ApiConfig {

    @Bean
    fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        return objectMapper
    }

    @Bean
    fun objectWriter(objectMapper: ObjectMapper) : ObjectWriter {
        return objectMapper.writerWithDefaultPrettyPrinter()
    }

    @Bean
    fun webClient() : WebClient {
        return WebClient.builder().clientConnector(ReactorClientHttpConnector()).build()
    }
}