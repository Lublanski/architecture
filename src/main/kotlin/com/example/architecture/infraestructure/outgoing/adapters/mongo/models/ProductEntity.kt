package com.example.architecture.infraestructure.outgoing.adapters.mongo.models

import com.example.architecture.domain.Product
import com.example.architecture.domain.`interface`.ProductInterface
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "product")
class ProductEntity(
    @Id
    override val id: String? = null,
    override val title: String,
    override val price: Double,
    override val dateCreated: Instant,
    override val externalId: String
): ProductInterface
