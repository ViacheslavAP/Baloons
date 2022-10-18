package ru.perelyginva.baloons.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.perelyginva.baloons.domain.useCase.ProductsUseCase

class ProductsViewModel(private val productsUseCase: ProductsUseCase): ViewModel()  {

    val loadProducts = productsUseCase.loadProducts()

    fun migration(context: Context) = viewModelScope.launch {

        productsUseCase.startMigration(context)
    }
}