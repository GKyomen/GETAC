package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.adapter.ProductItemListAdapter
import com.ibuild.getac.model.Product
import com.ibuild.getac.ui.HomeFragment
import com.ibuild.getac.ui.ReformFragment
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        imgProduct.requestFocus()

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

        //FALTA A LOGICA DE O USUARIO ESCOLHER TODOS OS PRODUTOS REFERENTES A REFORMA E DPOIS FINALIZAR.
        btnAddReform.setOnClickListener {
            val intent = Intent(this, ReformManualActivity::class.java)
            startActivity(intent)
        }

        val reformflag = intent.getBooleanExtra("REFORMFLAG", false)
        if(reformflag){
            productRelatedList.adapter = ProductItemListAdapter(products(), this) {}
            btnAddReform.isVisible = true
            imgStoreProduct.isClickable = false
            txtStoreNameProduct.isClickable = false
            txtStoreAdressProduct.isClickable = false
            txtProductPrice.isClickable = false
        }
    }

    private fun products(): List<Product> {
        return listOf(
            Product("Nome do produto 1", 3.50, 1, "un", "Tok\u0026Stok", 5.0),
            Product("Nome do produto 2", 9.99, 1, "kg", "Leroy Merlin", 4.9),
            Product("Nome do produto 3", 5.75, 1, "litro", "C\u0026C", 4.7),
            Product("Nome do produto 4", 7.50, 1, "un", "Telhanorte", 4.9),
            Product("Nome do produto 5", 2.30, 1, "metro", "Dicico", 4.8)
        )
    }
}
