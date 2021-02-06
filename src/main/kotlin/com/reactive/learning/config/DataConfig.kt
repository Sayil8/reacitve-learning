package com.reactive.learning.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@EnableReactiveMongoRepositories
@Configuration
class DataConfig : AbstractReactiveMongoConfiguration() {


    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create("mongodb://localhost:27017")
    }

    override fun getDatabaseName(): String {
        return "reactiveSpring"
    }
}