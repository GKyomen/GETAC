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

        imgStore.requestFocus()
      
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
            Product("Nome do produto 1", 3.50, 1, "un", "Tok\u0026Stok", 5.0),
            Product("Nome do produto 2", 9.99, 1, "kg", "Leroy Merlin", 4.9),
            Product("Nome do produto 3", 5.75, 1, "litro", "C\u0026C", 4.7),
            Product("Nome do produto 4", 7.50, 1, "un", "Telhanorte", 4.9),
            Product("Nome do produto 5", 2.30, 1, "metro", "Dicico", 4.8),
            Product("Nome do produto 6", 3.50, 1, "un", "Tok\u0026Stok", 5.0),
            Product("Nome do produto 7", 9.99, 1, "kg", "Leroy Merlin", 4.9),
            Product("Nome do produto 8", 5.75, 1, "litro", "C\u0026C", 4.7),
            Product("Nome do produto 9", 7.50, 1, "un", "Telhanorte", 4.9),
            Product("Nome do produto 10", 2.30, 1, "metro", "Dicico", 4.8),
            Product("Nome do produto 11", 2.30, 1, "metro", "Dicico", 4.8),
            Product("Nome do produto 12", 2.30, 1, "metro", "Dicico", 4.8),
            Product("Nome do produto 13", 2.30, 1, "metro", "Dicico", 4.8),
            Product("Nome do produto 14", 2.30, 1, "metro", "Dicico", 4.8),
            Product("Nome do produto 15", 2.30, 1, "metro", "Dicico", 4.8)
        )
    }
}
