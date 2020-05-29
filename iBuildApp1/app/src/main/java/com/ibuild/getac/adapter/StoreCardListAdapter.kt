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
                           private val onClick: (Store) -> Unit,
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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(store: Store) {
            val storeName = itemView.establishmentName
            val storeAddress = itemView.establishmentDescription
            //val storeRating = itemView.storeCardRating

            storeName.text = store.storeName
            storeAddress.text = store.storeAddress
            //storeRating.text = store.storeRating.toString() + "\u2605 (99+)"

            itemView.setOnClickListener {
                onClick(store)
            }
        }
    }
}