package ru.perelyginva.baloons.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import ru.perelyginva.baloons.data.models.ProductsModel
import ru.perelyginva.baloons.domain.repository.ProductsCall

class ProductsUseCase(private val productsCall: ProductsCall)  {

    fun loadProducts(): LiveData<List<ProductsModel>>{

        return productsCall.loadProducts()
    }

    suspend fun startMigration(context: Context){

        productsCall.startMigration(context)
    }
}