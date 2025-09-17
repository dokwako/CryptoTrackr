package com.example.cryptotrackr.ui.watchlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@Composable
fun WatchlistScreen(viewModel: WatchlistViewModel) {
    val coins = viewModel.coins

    LaunchedEffect(Unit) { viewModel.loadWatchlist() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("My Watchlist", style = MaterialTheme.typography.headlineMedium)
        if (coins.isEmpty()) {
            Text("No favorites yet!")
        } else {
            LazyColumn {
                items(coins) { coinId ->
                    Text(coinId, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
