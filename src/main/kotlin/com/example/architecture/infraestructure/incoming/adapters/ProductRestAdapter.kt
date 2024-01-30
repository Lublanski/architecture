package com.example.architecture.infraestructure.incoming.adapters

import com.example.architecture.application.services.ProductService
import com.example.architecture.domain.Product
import com.example.architecture.domain.`interface`.ProductInterface
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/products")
class ProductRestAdapter(
    @Qualifier("productService")
    private val productService: ProductService
) {

    @GetMapping("/{externalId}")
    suspend fun findProduct(@PathVariable externalId: String): ProductInterface =
        productService.findProduct(externalId)
}
