package com.example.architecture.infraestructure.outgoing.adapters.mongo

import com.example.architecture.application.interfaces.ProductApplicationRepository
import com.example.architecture.domain.Product
import com.example.architecture.domain.`interface`.ProductInterface
import com.example.architecture.infraestructure.mappers.ProductMapper
import com.example.architecture.infraestructure.outgoing.adapters.mongo.models.ProductEntity
import com.example.architecture.infraestructure.outgoing.adapters.mongo.repositories.ProductRepository
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Component

@Component
class MongoAdapter(
    private val productRepository: ProductRepository
): ProductApplicationRepository {

    override suspend fun findByExternal(externalId: String): ProductInterface? =
        productRepository.findByExternalId(externalId).awaitSingleOrNull()

    override suspend fun save(product: ProductInterface): ProductInterface =
        productRepository.save(
            ProductMapper.mapProductInterfaceToProductEntity(product)
        ).awaitSingle()

}
