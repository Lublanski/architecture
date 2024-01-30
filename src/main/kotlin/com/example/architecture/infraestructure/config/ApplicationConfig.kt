package com.example.architecture.infraestructure.config

import com.example.architecture.application.interfaces.MercadoLibreApiInterface
import com.example.architecture.application.interfaces.ProductApplicationRepository
import com.example.architecture.application.services.ProductService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    @Bean
    fun productService(
        mercadoLibreApiInterface: MercadoLibreApiInterface,
        productApplicationRepository: ProductApplicationRepository
    ): ProductService =
        ProductService(mercadoLibreApiInterface, productApplicationRepository)
}
