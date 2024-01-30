package com.example.architecture.domain.`interface`

import java.time.Instant

interface ProductInterface {
    val id: String?
    val title: String
    val price: Double
    val dateCreated: Instant
    val externalId: String
}
