package com.example.android.cryptocurrencyapp.presentation.coin_list

import com.example.android.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
    )
