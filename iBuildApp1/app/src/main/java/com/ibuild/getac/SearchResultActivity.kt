package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.adapter.ProductItemListAdapter
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.activity_search_result.*
import kotlinx.android.synthetic.main.activity_store.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        val searchQuery = intent.getStringExtra("SearchQuery")

        resultSearchView.setOnQueryTextListener( object : androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                searchResults.text = "# resultados para \"$query\""
                return false
            }

        })
        searchResults.text = "# resultados para \"$searchQuery\""
        resultSearchView.setQuery(searchQuery, false)

        searchProductList.adapter = ProductItemListAdapter(searchProducts(), this) {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("PRODUCT", it)
            startActivity(intent)
        }
        searchProductList.layoutManager = LinearLayoutManager(this)
    }

    private fun searchProducts(): List<Product> {
        return listOf(
            Product("Nome do produto 1", 3.50, "un", "Tok\u0026Stok"),
            Product("Nome do produto 2", 9.99, "kg", "Leroy Merlin"),
            Product("Nome do produto 3", 5.75, "litro", "C\u0026C"),
            Product("Nome do produto 4", 7.50, "un", "Telhanorte"),
            Product("Nome do produto 5", 2.30, "metro", "Dicico"),
            Product("Nome do produto 6", 2.30, "metro", "Dicico"),
            Product("Nome do produto 7", 2.30, "metro", "Dicico"),
            Product("Nome do produto 8", 2.30, "metro", "Dicico"),
            Product("Nome do produto 9", 2.30, "metro", "Dicico"),
            Product("Nome do produto 10", 2.30, "metro", "Dicico"),
            Product("Nome do produto 11", 2.30, "metro", "Dicico"),
            Product("Nome do produto 12", 2.30, "metro", "Dicico")

        )
    }
}