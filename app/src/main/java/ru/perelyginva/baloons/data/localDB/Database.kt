package ru.perelyginva.baloons.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.perelyginva.baloons.data.models.ProductsModel


@Database(entities = [ProductsModel::class], version = 1)
abstract  class Database: RoomDatabase() {
    abstract val productsDao: ProductsDao
}