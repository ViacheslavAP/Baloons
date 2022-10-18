package ru.perelyginva.baloons.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.perelyginva.baloons.data.models.ProductsModel

@Dao
interface ProductsDao {

    @Insert
    suspend fun insertProducts(productsModel: ProductsModel)

    @Query("SELECT * FROM product_data_table")
    fun getAllProducts(): LiveData<List<ProductsModel>>

    @Query("DELETE FROM product_data_table")
    suspend fun clear()
}