package ru.perelyginva.baloons.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.perelyginva.baloons.R
import ru.perelyginva.baloons.databinding.ActivityMainBinding
import ru.perelyginva.baloons.presentation.viewModel.ProductsViewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val productsViewModel: ProductsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        productsViewModel.migration(this)

        binding?.bottomNav?.selectedItemId = R.id.home

        binding?.bottomNav?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Home()).commit()

                R.id.balloons -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Products()).commit()
            }

            return@setOnItemSelectedListener true
        }

    }

}