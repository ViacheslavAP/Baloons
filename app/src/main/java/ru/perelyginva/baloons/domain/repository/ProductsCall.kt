package ru.perelyginva.baloons.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import ru.perelyginva.baloons.data.models.ProductsModel

interface ProductsCall  {

    fun loadProducts(): LiveData<List<ProductsModel>>

    suspend fun startMigration(context: Context)
}