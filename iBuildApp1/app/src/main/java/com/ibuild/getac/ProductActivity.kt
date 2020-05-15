package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.adapter.ProductItemListAdapter
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        productRelatedList.adapter = ProductItemListAdapter(products(), this) {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("PRODUCT", it)
            startActivity(intent)
        }
        productRelatedList.layoutManager = LinearLayoutManager(this)

        val product = intent.getSerializableExtra("PRODUCT") as Product
        txtNameProduct.text = product.prodName
        txtPriceProduct.text = "R$ " + product.prodPrice.toString()
        txtStoreNameProduct.text = product.prodStoreName
    }

    private fun products(): List<Product> {
        return listOf(
            Product("Nome do produto 1", 3.50, "un", "Tok\u0026Stok"),
            Product("Nome do produto 2", 9.99, "kg", "Leroy Merlin"),
            Product("Nome do produto 3", 5.75, "litro", "C\u0026C"),
            Product("Nome do produto op", 7.50, "un", "Telhanorte"),
            Product("Nome do produto 5", 2.30, "metro", "Dicico")
        )
    }
}
