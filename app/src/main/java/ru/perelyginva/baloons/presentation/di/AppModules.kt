package ru.perelyginva.baloons.presentation.di


import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.perelyginva.baloons.data.localDB.Database
import ru.perelyginva.baloons.data.repository.dataSource.ProductsApiDataSource
import ru.perelyginva.baloons.data.repository.dataSource.ProductsDataSource
import ru.perelyginva.baloons.data.repository.dataSourceIMPL.ProductsApiDataSourceIMPL
import ru.perelyginva.baloons.data.repository.dataSourceIMPL.ProductsDataSourceIMPL
import ru.perelyginva.baloons.data.repository.repository.ProductsRepository
import ru.perelyginva.baloons.domain.repository.ProductsCall
import ru.perelyginva.baloons.domain.useCase.ProductsUseCase
import ru.perelyginva.baloons.presentation.viewModel.ProductsViewModel

val moduleProducts = module {

    single {
        Room.databaseBuilder(
            androidContext(), Database::class.java,
            "localDB").build()
    }

    single { get<Database>().productsDao }

    single<ProductsDataSource> {

        ProductsDataSourceIMPL(get())
    }

    single<ProductsApiDataSource> {

        ProductsApiDataSourceIMPL(get())
    }

    single<ProductsCall> { ProductsRepository(get(), get()) }

    single { ProductsUseCase(get()) }

    viewModel { ProductsViewModel(get()) }
}