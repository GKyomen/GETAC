package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.adapter.ProductItemListAdapter
import com.ibuild.getac.model.Product
import com.ibuild.getac.model.Store
import kotlinx.android.synthetic.main.activity_store.*

class StoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        val store = intent.getSerializableExtra("STORE") as Store
        txtNameAdressStore.text = store.storeName
        txtAdressStore.text = store.storeAddress

        productList.adapter = ProductItemListAdapter(products(), this) {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("PRODUCT", it)
            startActivity(intent)
        }
        productList.layoutManager = LinearLayoutManager(this)
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
