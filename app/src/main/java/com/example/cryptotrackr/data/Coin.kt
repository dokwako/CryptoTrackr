package com.example.cryptotrackr.data

import com.squareup.moshi.Json

data class Coin(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "current_price") val currentPrice: Double,
    @Json(name = "price_change_percentage_24h") val priceChangePercentage24h: Double,
    @Json(name = "image") val image: String
)