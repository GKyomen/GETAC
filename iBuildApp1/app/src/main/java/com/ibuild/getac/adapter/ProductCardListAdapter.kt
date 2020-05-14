package com.ibuild.getac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.product_card.view.*

class ProductCardListAdapter(private val products: List<Product>,
                             private val onClick : (Product) -> Unit,
                             private val context: Context) : RecyclerView.Adapter<ProductCardListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bindView(product)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(product: Product) {
            val name = itemView.productName
            val price = itemView.productPrice
            val store = itemView.productEstablishment

            name.text = product.prodName
            price.text = "Por apenas R$ " + product.prodPrice + " por " + product.prodUnit
            store.text = "Fornecido por: " + product.prodStoreName

            itemView.setOnClickListener {
                onClick(product)
            }
        }
    }
}