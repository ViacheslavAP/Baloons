package ru.perelyginva.baloons.data.repository.dataSource

import android.content.Context

interface ProductsApiDataSource {

    fun startMigration(context: Context)
}