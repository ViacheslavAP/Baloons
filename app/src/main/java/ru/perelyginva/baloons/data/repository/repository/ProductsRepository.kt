package ru.perelyginva.baloons.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import ru.perelyginva.baloons.data.models.ProductsModel
import ru.perelyginva.baloons.data.repository.dataSource.ProductsApiDataSource
import ru.perelyginva.baloons.data.repository.dataSource.ProductsDataSource
import ru.perelyginva.baloons.domain.repository.ProductsCall

class ProductsRepository(
    private val productsApiDataSource: ProductsApiDataSource,
    private val productsDataSource: ProductsDataSource
): ProductsCall {

    override fun loadProducts(): LiveData<List<ProductsModel>>{
        return productsDataSource.loadProducts()
    }

    override suspend fun startMigration(context: Context){

        productsDataSource.clear()
        productsApiDataSource.startMigration(context)
    }
}