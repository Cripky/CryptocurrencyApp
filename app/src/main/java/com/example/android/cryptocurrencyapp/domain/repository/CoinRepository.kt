package com.example.android.cryptocurrencyapp.domain.repository

import com.example.android.cryptocurrencyapp.common.Resource
import com.example.android.cryptocurrencyapp.domain.model.Coin
import com.example.android.cryptocurrencyapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins(): Flow<Resource<List<Coin>>>

    suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}