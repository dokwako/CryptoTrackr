package com.example.cryptotrackr.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.cryptotrackr.data.Coin
import com.example.cryptotrackr.viewmodel.CoinViewModel

@Composable
fun CoinListScreen(
    viewModel: CoinViewModel = hiltViewModel(),
    onWatchlistClick: () -> Unit                // For navigation to Watchlist
) {
    val uiState = viewModel.uiState.collectAsState().value

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Crypto Tracker", style = MaterialTheme.typography.headlineMedium)

        when (uiState) {
            is CoinViewModel.UiState.Loading ->
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))

            is CoinViewModel.UiState.Error ->
                Text(text = uiState.message, color = MaterialTheme.colorScheme.error)

            is CoinViewModel.UiState.Success -> {
                LazyColumn {
                    items(uiState.coins) { coin ->
                        CoinItem(coin = coin)
                    }
                }
            }
        }
    }
}

@Composable
fun CoinItem(coin: Coin) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        AsyncImage(
            model = coin.image,
            contentDescription = "${coin.name} icon",
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(text = coin.name, style = MaterialTheme.typography.titleMedium)
        Text(text = "Price: $${String.format("%.2f", coin.currentPrice)}")
        Text(text = "24h Change: ${String.format("%.2f", coin.priceChangePercentage24h)}%")
    }
}
