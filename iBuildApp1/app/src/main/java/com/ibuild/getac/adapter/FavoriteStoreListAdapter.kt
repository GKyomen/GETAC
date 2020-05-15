package com.ibuild.getac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.model.Store
import kotlinx.android.synthetic.main.favorite_store_item.view.*


class FavoriteStoreListAdapter(private val stores : List<Store>,
                               private val context : Context) : RecyclerView.Adapter<FavoriteStoreListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.favorite_store_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stores.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores[position]
        holder.bindView(store)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView (store: Store){
            val name = itemView.favoriteStoreName
            val adress = itemView.favoriteStoreAdress
            name.text = store.storeName
            adress.text = store.storeAddress
        }
    }

}

