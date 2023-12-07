package com.example.android.cryptocurrencyapp.data.repository

import com.example.android.cryptocurrencyapp.common.Resource
import com.example.android.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.android.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.android.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.example.android.cryptocurrencyapp.domain.model.Coin
import com.example.android.cryptocurrencyapp.domain.model.CoinDetail
import com.example.android.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

    override suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = api.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}