package com.example.cryptotrackr.ui.watchlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cryptotrackr.repository.WatchlistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val repo: WatchlistRepository
) : ViewModel() {
    var coins by mutableStateOf<List<String>>(emptyList())
        private set

    fun loadWatchlist() {
        repo.getWatchlist { coins = it }
    }

    fun add(coinId: String) {
        repo.addToWatchlist(coinId)
        loadWatchlist()
    }

    fun remove(coinId: String) {
        repo.removeFromWatchlist(coinId)
        loadWatchlist()
    }
}
