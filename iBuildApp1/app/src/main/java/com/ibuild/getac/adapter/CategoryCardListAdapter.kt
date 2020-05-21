package com.ibuild.getac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import kotlinx.android.synthetic.main.category_card.view.*

class CategoryCardListAdapter(private val categories: List<String>,
                              private val onClick: (String) -> Unit,
                              private val context: Context
                                ) : RecyclerView.Adapter<CategoryCardListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categories = categories[position]
        holder.bindView(categories, onClick)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(category: String, onClick: (String) -> Unit) {
            val name = itemView.categoryName
            name.text = category

            itemView.setOnClickListener{ onClick(category) }
        }
    }
}