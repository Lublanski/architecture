package com.example.architecture.infraestructure.outgoing.adapters.mongo.repositories

import com.example.architecture.infraestructure.outgoing.adapters.mongo.models.ProductEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface ProductRepository: ReactiveMongoRepository<ProductEntity, String> {

    fun findByExternalId(externalId: String): Mono<ProductEntity>
}
