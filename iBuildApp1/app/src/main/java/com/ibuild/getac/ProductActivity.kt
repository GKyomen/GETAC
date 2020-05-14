package com.ibuild.getac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val product = intent.getSerializableExtra("PRODUCT") as Product
        txtNameProduct.text = product.prodName
        txtPriceProduct.text = "R$ " + product.prodPrice.toString()
        txtStoreNameProduct.text = product.prodStoreName
    }
}
