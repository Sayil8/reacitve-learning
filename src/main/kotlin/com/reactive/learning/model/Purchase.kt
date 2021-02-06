package com.reactive.learning.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Purchase(val name: String,
                    val price: String,
                    val createdAt: LocalDateTime) {
   @Id val id: String = ""
}