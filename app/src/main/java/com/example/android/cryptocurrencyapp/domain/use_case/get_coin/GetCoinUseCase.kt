package com.example.android.cryptocurrencyapp.domain.use_case.get_coin

import com.example.android.cryptocurrencyapp.common.Resource
import com.example.android.cryptocurrencyapp.domain.model.CoinDetail
import com.example.android.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    suspend operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return repository.getCoinById(coinId)
    }
}