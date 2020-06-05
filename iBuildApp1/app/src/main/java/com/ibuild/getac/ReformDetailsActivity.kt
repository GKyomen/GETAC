package com.ibuild.getac

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.adapter.ReformDetailsItemAdapter
import com.ibuild.getac.model.Product
import kotlinx.android.synthetic.main.activity_reform_details.*
import kotlinx.android.synthetic.main.alert_dialog_with_edittext.view.*

class ReformDetailsActivity : AppCompatActivity() {

    var intentBudget : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reform_details)

        btnEditDataReform.setOnClickListener {
            val inflater = layoutInflater
            val items = arrayOf("Pedregulho", "Latossolo Argiloso", "Arenoso", "Bolo Fofo")
            var selected = ""
            val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)

            val builder = AlertDialog.Builder(this)
            with(builder) {
                setTitle("Alterar dados da reforma")
                setView(dialogLayout)
                setSingleChoiceItems(items, 0) { dialogInterface , isChecked ->
                    selected = items[isChecked]
                }
                setPositiveButton(android.R.string.ok) { _, _ ->
                    txtEditHeightReform.text = dialogLayout.inputNameReform.text.toString()
                    txtEditWidthReform.text = dialogLayout.inputNameReform.text.toString()
                    txtEditTypeGroundReform.text = selected
                    Toast.makeText(applicationContext,
                        "Alterado com sucesso!", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton(android.R.string.no) { _: DialogInterface, _: Int ->
                    Toast.makeText(applicationContext,
                        android.R.string.no, Toast.LENGTH_SHORT).show()
                }
                show()
            }
        }

        btnEditNameReform.setOnClickListener {
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)

            val builder = AlertDialog.Builder(this)
            with(builder) {
                setTitle("Alterar nome da reforma")
                setView(dialogLayout)
                setPositiveButton(android.R.string.ok) { _, _ ->
                    txtNameReform.text = dialogLayout.inputNameReform.text.toString()
                    Toast.makeText(applicationContext,
                        "Renomeado com sucesso!", Toast.LENGTH_SHORT).show()
                }
                show()
            }
        }

        btnRecalculateReform.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            with(builder) {
                setTitle("Recalcular para o padrão")
                setMessage("\nTem certeza que deseja recalcular toda a quantidade de material para o padrão?")

                setPositiveButton(android.R.string.yes) { _: DialogInterface, _: Int ->
                    Toast.makeText(applicationContext,
                        "Recalculado com sucesso", Toast.LENGTH_SHORT).show()
                }

                setNegativeButton(android.R.string.no) { _: DialogInterface, _: Int ->
                    Toast.makeText(applicationContext,
                        android.R.string.no, Toast.LENGTH_SHORT).show()
                }
                show()
            }
        }

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