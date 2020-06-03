package com.ibuild.getac

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.adapter.ReformDetailsItemAdapter
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.activity_reform_details.*


class ReformDetailsActivity : AppCompatActivity() {

    var intentBudget : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reform_details)

        switchBudget.setOnCheckedChangeListener { buttonView, isChecked ->
            intentBudget = if(isChecked) {
                isChecked
            } else {
                isChecked
            }
        }

        btnConfirmReform.setOnClickListener {
            if(intentBudget){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else {
                val intent = Intent(this, ReformManualActivity::class.java)
                startActivity(intent)
            }
            finish()
        }

        materialsReformManualList.adapter = ReformDetailsItemAdapter(products(), this,
        //onClickListener
        {

        },
        //onFocusChangeListener
        {

        })
        materialsReformManualList.layoutManager = LinearLayoutManager(this)
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
            Product("Nome do produto 10", 2.30, 1, "metro", "Dicico", 4.8)
        )
    }
}
