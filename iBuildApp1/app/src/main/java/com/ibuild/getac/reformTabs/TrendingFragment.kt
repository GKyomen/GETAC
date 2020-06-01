package com.ibuild.getac.reformTabs

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.ProductActivity
import com.ibuild.getac.R
import com.ibuild.getac.adapter.TrendingProductListAdapter
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.fragment_trending.*

class TrendingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            trendingProductListRecycler.adapter = getView()?.let { it ->
                TrendingProductListAdapter(products(), {
                    val intent = Intent(activity, ProductActivity::class.java)
                    intent.putExtra("PRODUCT", it)
                    startActivity(intent)
                },it.context)
            }
        trendingProductListRecycler.layoutManager = LinearLayoutManager(getView()?.context)
    }

    private fun products(): List<Product> {
        return listOf(
            Product("Nome do produto 1", 3.50, "un", "Tok\u0026Stok", 5.0),
            Product("Nome do produto 2", 9.99, "kg", "Leroy Merlin", 4.9),
            Product("Nome do produto 3", 5.75, "litro", "C\u0026C", 4.7),
            Product("Nome do produto 4", 7.50, "un", "Telhanorte", 4.9),
            Product("Nome do produto 5", 2.30, "metro", "Dicico", 4.8)
        )
    }
}
