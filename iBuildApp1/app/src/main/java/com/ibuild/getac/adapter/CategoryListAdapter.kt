package com.ibuild.getac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.model.ReformCategory
import kotlinx.android.synthetic.main.reform_category_button.view.*

class CategoryListAdapter(private val categories: List<ReformCategory>,
                          private val onClick : (ReformCategory) -> Unit,
                          private val context: Context) : RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reform_category_button, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.bindView(category)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(category: ReformCategory) {
            val name = itemView.reformCategoryName

            name.text = category.categoryName

            itemView.setOnClickListener {
                onClick(category)
            }
        }
    }
}