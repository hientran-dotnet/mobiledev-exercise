package com.example.getapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ProductUiState {
    object Loading : ProductUiState()
    data class Success(val product: Product) : ProductUiState()
    data class Error(val message: String) : ProductUiState()
}

class ProductViewModel : ViewModel() {
    private val apiService = ApiService.create()

    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)
    val uiState: StateFlow<ProductUiState> = _uiState.asStateFlow()

    init {
        fetchProduct()
    }

    fun fetchProduct() {
        viewModelScope.launch {
            _uiState.value = ProductUiState.Loading
            try {
                val product = apiService.getProduct()
                _uiState.value = ProductUiState.Success(product)
            } catch (e: Exception) {
                _uiState.value = ProductUiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
}

