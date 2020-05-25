package com.ibuild.getac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.ibuild.getac.R
import com.ibuild.getac.model.Reform
import kotlinx.android.synthetic.main.reform_card.view.*
import org.threeten.bp.format.DateTimeFormatter

class ReformCardListAdapter(private val reforms: List<Reform>,
                            private val context: Context) : RecyclerView.Adapter<ReformCardListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reform_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reforms.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reform = reforms[position]
        holder.bindView(reform)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(reform: Reform) {

            val reformTitle = itemView.txtReformNameCard
            val reformCategory = itemView.txtReformCategoryCard
            val btnExpand = itemView.btnExpandMyReform
            val reformProductsQty = listOf<TextView>(
                itemView.txtReformCardProductQty1,
                itemView.txtReformCardProductQty2,
                itemView.txtReformCardProductQty3,
                itemView.txtReformCardProductQty4,
                itemView.txtReformCardProductQty5
            )
            val reformProductsNames = listOf<TextView>(
                itemView.txtReformCardProductName1,
                itemView.txtReformCardProductName2,
                itemView.txtReformCardProductName3,
                itemView.txtReformCardProductName4,
                itemView.txtReformCardProductName5
            )
            val reformProductsPrices = listOf<TextView>(
                itemView.txtReformCardProductPrice1,
                itemView.txtReformCardProductPrice2,
                itemView.txtReformCardProductPrice3,
                itemView.txtReformCardProductPrice4,
                itemView.txtReformCardProductPrice5
            )
            val reformTotalValueText = itemView.txtReformCardValueTotal
            val reformStore = itemView.txtReformCardBudgetedStore
            val reformDate = itemView.txtReformCardBudgetDate
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

            reformTitle.text = reform.reformTitle
            reformCategory.text = reform.reformCategory.categoryName

            btnExpand.setOnClickListener{
                if (itemView.expandableViewReformCard.visibility == View.GONE) {
                    TransitionManager.beginDelayedTransition(itemView.reformCard, AutoTransition())
                    itemView.expandableViewReformCard.visibility = View.VISIBLE
                    btnExpand.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_32dp)
                } else {
                    TransitionManager.beginDelayedTransition(itemView.reformCard, AutoTransition())
                    itemView.expandableViewReformCard.visibility = View.GONE
                    btnExpand.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_48dp)
                }
            }

            if (reform.products.size < reformProductsQty.size) {
                for ((i, product) in reform.products.withIndex()) {
                    reformProductsQty[i].text = product.prodQty.toString() + "x"
                    reformProductsNames[i].text = product.prodName
                    reformProductsPrices[i].text = "R$ " + String.format("%.2f", product.prodPrice)
                }

                for(i in reform.products.size until reformProductsQty.size) {
                    reformProductsQty[i].visibility = View.GONE
                    reformProductsNames[i].visibility = View.GONE
                    reformProductsPrices[i].visibility = View.GONE
                }
            } else {
                for ((i, qty) in reformProductsQty.withIndex()) {
                    qty.text = reform.products[i].prodQty.toString() + "x"
                }

                for ((i, name) in reformProductsNames.withIndex()) {
                    name.text = reform.products[i].prodName
                }

                for ((i, price) in reformProductsPrices.withIndex()) {
                    price.text = "R$ " + String.format("%.2f", reform.products[i].prodPrice)
                }
            }

            reformTotalValueText.text = "R$ " + String.format("%.2f", reform.reformTotalValue)
            reformStore.text = "Orçado com: " + reform.store.storeName
            reformDate.text = "Feito em: " + reform.reformDate.format(formatter)
        }
    }
}