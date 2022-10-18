package ru.perelyginva.baloons.data.repository.dataSource

import androidx.lifecycle.LiveData
import ru.perelyginva.baloons.data.models.ProductsModel

interface ProductsDataSource  {

    fun insert(productsModel: ProductsModel)

    fun loadProducts(): LiveData<List<ProductsModel>>

    suspend fun clear()
}