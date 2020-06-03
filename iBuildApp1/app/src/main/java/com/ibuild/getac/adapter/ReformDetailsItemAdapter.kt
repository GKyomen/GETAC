package com.ibuild.getac.adapter

import android.content.Context
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.reform_details_item.view.*

class ReformDetailsItemAdapter(private val materials: List<Product>,
                               private val context: Context,
                               private val onClick : (View) -> Unit,
                               private val onFocusChange : (View) -> Unit) : RecyclerView.Adapter<ReformDetailsItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reform_details_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return materials.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val material = materials[position]
        holder.bindView(material)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(materials: Product) {
            val name = itemView.txtNameMaterial
            val quantity = itemView.inputQtyMaterial

            name.text = materials.prodName
            quantity.setText((materials.prodQty).toString())

            itemView.inputQtyMaterial.setOnClickListener {
                onClick(itemView)
            }

            itemView.inputQtyMaterial.setOnClickListener {
                onFocusChange(itemView)
            }
        }
    }
}