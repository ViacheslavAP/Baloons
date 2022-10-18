package ru.perelyginva.baloons.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.perelyginva.baloons.data.models.ProductsModel
import ru.perelyginva.baloons.databinding.ProductItemBinding

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    private val productsList = ArrayList<ProductsModel>()

    class ProductHolder(private val binding: ProductItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(productsModel: ProductsModel){

            val getImage = productsModel.image
            Picasso.get().load(getImage).into(binding.imageProduct)
            binding.idProduct.text = productsModel.id.toString()
            binding.nameProduct.text = productsModel.name
            binding.categoryProduct.text = productsModel.category
            binding.priceProduct.text = productsModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val binding: ProductItemBinding = ProductItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {

        holder.bind(productsList[position])
    }

    override fun getItemCount(): Int {

        return  productsList.size
    }

    fun setList(products: List<ProductsModel>){

        productsList.clear()
        productsList.addAll(products)
    }
}