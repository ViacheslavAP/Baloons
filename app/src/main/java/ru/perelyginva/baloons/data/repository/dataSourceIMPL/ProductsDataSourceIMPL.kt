package ru.perelyginva.baloons.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.perelyginva.baloons.data.localDB.ProductsDao
import ru.perelyginva.baloons.data.models.ProductsModel
import ru.perelyginva.baloons.data.repository.dataSource.ProductsDataSource

class ProductsDataSourceIMPL(private val dao: ProductsDao): ProductsDataSource {

    override fun insert(productsModel: ProductsModel){
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertProducts(productsModel)
        }
    }

    override fun loadProducts(): LiveData<List<ProductsModel>>{
        return dao.getAllProducts()
    }

    override suspend fun clear(){
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()
        }
    }
}