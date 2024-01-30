package com.example.architecture.infraestructure.outgoing.adapters.mercadolibreapi.model

import java.time.Instant

data class ProductMercadoLibreApi(
    val id: String,
    val title: String,
    val dateCreated: Instant,
    val price: Double,
    val siteId: String,
    val sellerId: Long,
    val basePrice: Double
)
