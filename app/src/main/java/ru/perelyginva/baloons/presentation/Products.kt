package ru.perelyginva.baloons.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.perelyginva.baloons.R
import ru.perelyginva.baloons.databinding.FragmentProductsBinding
import ru.perelyginva.baloons.presentation.viewModel.ProductsViewModel


class Products : Fragment() {

    private var binding: FragmentProductsBinding? = null
    private var productsAdapter: ProductsAdapter? = null
    val productsViewModel: ProductsViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)

        initRecyclerProducts()

        loadProducts()

        return binding?.root

    }

    private fun loadProducts() {
        productsViewModel.loadProducts.observe(viewLifecycleOwner, Observer {

            productsAdapter?.setList(it)
            productsAdapter?.notifyDataSetChanged()
        })
    }

    private fun initRecyclerProducts() {

        binding?.recyclerProducts?.layoutManager = LinearLayoutManager(context)
        productsAdapter = ProductsAdapter()
        binding?.recyclerProducts?.adapter = productsAdapter
    }


}