package com.example.bakkaldefteri.api

data class ApiResponse(val conversion_rates: ResponseCurrencies)

data class ResponseCurrencies(
    val TRY: Float,
    val EUR: Float,
    val USD: Float,
    val GBP: Float)