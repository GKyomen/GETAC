package com.ibuild.getac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.model.Product
import com.ibuild.getac.model.Store
import kotlinx.android.synthetic.main.store_card.view.*

class StoreCardListAdapter(var items: List<Store>,
                           var clickListener: OnStoreCardItemClickListener,
                           var context: Context) : RecyclerView.Adapter<StoreCardViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreCardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.store_card, parent, false)
        return StoreCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreCardViewHolder, position: Int) {
        holder.initialize(items[position], clickListener)
    }
}

class StoreCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val storeName = itemView.establishmentName
    val storeAddress = itemView.establishmentDescription
    //val storeRating = itemView.storeCardRating

    fun initialize(item: Store, action:OnStoreCardItemClickListener){
        storeName.text = item.storeName
        storeAddress.text = item.storeAddress
        //storeRating.text = store.storeRating.toString() + "\u2605 (99+)"

        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnStoreCardItemClickListener{
    fun onItemClick(item: Store, position: Int)
}