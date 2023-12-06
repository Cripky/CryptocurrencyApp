package com.example.android.cryptocurrencyapp.domain.repository

import com.example.android.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.android.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}