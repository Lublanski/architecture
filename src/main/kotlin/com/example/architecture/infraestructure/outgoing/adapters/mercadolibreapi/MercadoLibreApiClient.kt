package com.example.architecture.infraestructure.outgoing.adapters.mercadolibreapi

import com.example.architecture.infraestructure.outgoing.adapters.mercadolibreapi.model.ProductMercadoLibreApi
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class MercadoLibreApiClient(
    @Qualifier("snakeCaseObjectMapper")
    private val objectMapper: ObjectMapper
) {

    private val exchangeStrategies = ExchangeStrategies.builder()
        .codecs {
            it.defaultCodecs().jackson2JsonEncoder(Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON))
            it.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(objectMapper, MediaType.APPLICATION_JSON))
        }
        .build()

    private val webClient = WebClient.builder()
        .baseUrl("https://api.mercadolibre.com")
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .exchangeStrategies(exchangeStrategies)
        .build()


    suspend fun findProduct(externalId: String): ProductMercadoLibreApi =
        webClient
            .get()
            .uri("/items/$externalId")
            .retrieve()
            .awaitBody()
}