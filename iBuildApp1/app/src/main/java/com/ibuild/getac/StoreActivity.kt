package com.ibuild.getac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.adapter.ProductItemListAdapter
import com.ibuild.getac.model.Product

class StoreActivity : AppCompatActivity() {

    private lateinit var prodList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        prodList = findViewById(R.id.productList)
        prodList.adapter = ProductItemListAdapter(products(), this)
        prodList.layoutManager = LinearLayoutManager(this)
    }

    private fun products(): List<Product> {
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
            Product("Nome do produto 12", 2.30, "metro", "Dicico"),
            Product("Nome do produto 13", 2.30, "metro", "Dicico")
        )
    }
}
