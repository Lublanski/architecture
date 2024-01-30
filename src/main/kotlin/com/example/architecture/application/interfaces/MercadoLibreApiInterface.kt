package com.example.architecture.application.interfaces

import com.example.architecture.domain.Product

interface MercadoLibreApiInterface {

    suspend fun findProduct(externalId: String): Product
}
