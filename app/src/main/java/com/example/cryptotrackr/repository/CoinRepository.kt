package com.example.cryptotrackr.repository

import com.example.cryptotrackr.BuildConfig
import com.example.cryptotrackr.data.Coin
import com.example.cryptotrackr.data.CoinGeckoApi
import javax.inject.Inject

class CoinRepository @Inject constructor(private val api: CoinGeckoApi) {
    suspend fun getCoins(): List<Coin> {
        return api.getCoins(apiKey = BuildConfig.COINGECKO_API_KEY)
    }
}