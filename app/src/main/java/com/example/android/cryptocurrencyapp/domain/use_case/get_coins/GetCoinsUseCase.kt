package com.example.android.cryptocurrencyapp.domain.use_case.get_coins

import com.example.android.cryptocurrencyapp.common.Resource
import com.example.android.cryptocurrencyapp.domain.model.Coin
import com.example.android.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    suspend operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoins()
    }
}