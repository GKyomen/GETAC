package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.R.layout
import com.ibuild.getac.adapter.ReformManualProductItemAdapter
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.activity_reform_manual.*

class ReformManualActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_reform_manual)

        productReformManualList.adapter = ReformManualProductItemAdapter(products(), this) {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("PRODUCT", it)
            intent.putExtra("REFORMFLAG", true)
            startActivity(intent)
        }
        productReformManualList.layoutManager = LinearLayoutManager(this)
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
