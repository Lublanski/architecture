package com.example.architecture.infraestructure.mappers

import com.example.architecture.domain.Product
import com.example.architecture.domain.`interface`.ProductInterface
import com.example.architecture.infraestructure.outgoing.adapters.mercadolibreapi.model.ProductMercadoLibreApi
import com.example.architecture.infraestructure.outgoing.adapters.mongo.models.ProductEntity

object ProductMapper {

    fun mapProductMercadoLibreApiToProduct(productMercadoLibreApi: ProductMercadoLibreApi): Product =
        productMercadoLibreApi.let {
            Product(
                externalId = it.id,
                title = it.title,
                price = it.price,
                dateCreated = it.dateCreated
            )
        }

    fun mapProductInterfaceToProductEntity(productInterface: ProductInterface): ProductEntity =
        productInterface.let {
            ProductEntity(
                id = it.id,
                externalId = it.externalId,
                title = it.title,
                price = it.price,
                dateCreated = it.dateCreated
            )
        }

}
