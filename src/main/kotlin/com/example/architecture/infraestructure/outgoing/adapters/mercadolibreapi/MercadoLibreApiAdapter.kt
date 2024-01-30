package com.example.architecture.infraestructure.outgoing.adapters.mercadolibreapi

import com.example.architecture.application.interfaces.MercadoLibreApiInterface
import com.example.architecture.domain.Product
import com.example.architecture.infraestructure.mappers.ProductMapper
import org.springframework.stereotype.Component

@Component
class MercadoLibreApiAdapter(
    private val mercadoLibreApiClient: MercadoLibreApiClient
): MercadoLibreApiInterface {

    override suspend fun findProduct(externalId: String): Product =
        ProductMapper.mapProductMercadoLibreApiToProduct(
            mercadoLibreApiClient.findProduct(externalId)
        )
}
