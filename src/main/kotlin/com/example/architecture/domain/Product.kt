package com.example.architecture.domain

import com.example.architecture.domain.`interface`.ProductInterface
import java.time.Instant

data class Product(
    override val id: String? = null,
    override val title: String,
    override val price: Double,
    override val dateCreated: Instant,
    override val externalId: String
): ProductInterface
