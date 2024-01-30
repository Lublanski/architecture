package com.example.architecture.application.services

import com.example.architecture.application.interfaces.MercadoLibreApiInterface
import com.example.architecture.application.interfaces.ProductApplicationRepository
import com.example.architecture.domain.`interface`.ProductInterface

class ProductService(
    private val mercadoLibreApiInterface: MercadoLibreApiInterface,
    private val productApplicationRepository: ProductApplicationRepository
) {

    suspend fun findProduct(externalId: String): ProductInterface =
        productApplicationRepository.findByExternal(externalId)
            ?: mercadoLibreApiInterface.findProduct(externalId).let {
                productApplicationRepository.save(it)
            }
}
