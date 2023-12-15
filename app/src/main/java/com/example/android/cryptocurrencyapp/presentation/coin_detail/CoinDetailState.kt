package com.example.android.cryptocurrencyapp.presentation.coin_detail

import com.example.android.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
