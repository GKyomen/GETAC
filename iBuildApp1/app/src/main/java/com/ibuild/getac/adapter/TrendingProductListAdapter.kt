package com.ibuild.getac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.reform_trending_item.view.*

class TrendingProductListAdapter(private val products: List<Product>,
                                 private val onClick : (Product) -> Unit,
                                 private val context: Context) : RecyclerView.Adapter<TrendingProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reform_trending_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bindView(product, position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(product: Product, position: Int) {
            val name            = itemView.txtProductNameTrending
            val price           = itemView.txtProductPriceTrending
            val store           = itemView.txtProductStoreTrending
            val storeRating     = itemView.txtProductStoreRatingTrending
            val itemPosition    = itemView.txtProductPositionTrending

            name.text = product.prodName
            price.text = "R$ " + product.prodPrice.toString() + " por " + product.prodUnit
            store.text = product.prodStoreName
            storeRating.text = product.prodStoreRating.toString() + "\u2605 (99+)"
            itemPosition.text = position.toString()

            itemView.setOnClickListener {
                onClick(product)
            }
        }
    }
}