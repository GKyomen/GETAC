package com.ibuild.getac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.reform_manual_product_item.view.*

class ReformManualProductItemAdapter(private val products: List<Product>,
                                     private val context: Context,
                                     private val onClick : (Product) -> Unit) : RecyclerView.Adapter<ReformManualProductItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reform_manual_product_item, parent, false)
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
            val name = itemView.txtProductNameReformManual
            val price = itemView.txtProductPriceReformManual
            val store = itemView.txtProductStoreReformManual
            val rating = itemView.txtProductStoreRatingReformManual

            name.text = product.prodName
            price.text = "R$ " + product.prodPrice + "por " + product.prodUnit
            store.text = product.prodStoreName
            rating.text = "4,7 ★ (99+)"

            itemView.setOnClickListener {
                onClick(product)
            }
        }
    }
}