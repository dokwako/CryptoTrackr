package com.example.cryptotrackr.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotrackr.data.Coin
import com.example.cryptotrackr.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(private val repository: CoinRepository) : ViewModel() {
    sealed class UiState {
        data class Success(val coins: List<Coin>) : UiState()
        object Loading : UiState()
        data class Error(val message: String) : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        fetchCoins()
    }

    private fun fetchCoins() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val coinList = repository.getCoins()
                _uiState.value = UiState.Success(coinList)
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to load coins: ${e.message}")
            }
        }
    }
}