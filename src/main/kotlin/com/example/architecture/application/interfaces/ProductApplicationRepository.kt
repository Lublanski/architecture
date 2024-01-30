package com.example.architecture.application.interfaces

import com.example.architecture.domain.Product
import com.example.architecture.domain.`interface`.ProductInterface

interface ProductApplicationRepository {

    suspend fun findByExternal(externalId: String): ProductInterface?

    suspend fun save(product: ProductInterface): ProductInterface
}
