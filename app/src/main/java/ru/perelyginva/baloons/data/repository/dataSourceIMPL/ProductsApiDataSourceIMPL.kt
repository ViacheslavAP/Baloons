package ru.perelyginva.baloons.data.repository.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.perelyginva.baloons.data.api.ApiClient
import ru.perelyginva.baloons.data.models.ProductsApiModel
import ru.perelyginva.baloons.data.models.ProductsModel
import ru.perelyginva.baloons.data.repository.dataSource.ProductsApiDataSource
import ru.perelyginva.baloons.data.repository.dataSource.ProductsDataSource

class ProductsApiDataSourceIMPL(
    private val productsDataSource: ProductsDataSource,
) : ProductsApiDataSource {

    override fun startMigration (context: Context) {

        val call = ApiClient.instance?.api?.getProduct()
        call?.enqueue(object: Callback<ArrayList<ProductsApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<ProductsApiModel>>,
                response: Response<ArrayList<ProductsApiModel>>
            ) {

                var loadProducts: ArrayList<ProductsApiModel>? = null

                loadProducts?.clear()

                loadProducts = response.body()!!

                for (audit in loadProducts) {

                    audit.id?.let {
                        ProductsModel(
                            it,
                            audit.name.toString(),
                            audit.image.toString(),
                            audit.category.toString(),
                            audit.price.toString()
                        )
                    }?.let {
                        productsDataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<ArrayList<ProductsApiModel>>, t: Throwable) {
                Toast.makeText(
                    context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }
}