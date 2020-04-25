package com.ibuild.getac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.model.Store
import kotlinx.android.synthetic.main.store_card.view.*

class StoreCardListAdapter(private val stores: List<Store>,
                           private val context: Context) : RecyclerView.Adapter<StoreCardListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.store_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stores.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores[position]
        holder.bindView(store)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(store: Store) {
            val name = itemView.storeCardNameAndImg
            val address = itemView.storeCardLocation
            val rating = itemView.storeCardRating

            name.text = store.storeName
            address.text = store.storeAddress
            rating.text = store.storeRating.toString() + "\u2605 (99+)"
        }
    }

}