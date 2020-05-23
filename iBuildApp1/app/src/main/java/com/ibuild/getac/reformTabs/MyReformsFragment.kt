package com.ibuild.getac.reformTabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.R
import com.ibuild.getac.adapter.ReformCardListAdapter
import com.ibuild.getac.model.Product
import com.ibuild.getac.model.Reform
import com.ibuild.getac.model.ReformCategory
import com.ibuild.getac.model.Store
import kotlinx.android.synthetic.main.fragment_my_reforms.*
import org.threeten.bp.LocalDate

class MyReformsFragment : Fragment() {

    private val store = Store("Leroy Merlin", "Nome da Rua 1 -  Cidade A", 5.0)
    private val reformCategory =  ReformCategory("Cozinha")
    private val reformDate = LocalDate.now()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my_reforms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myReformsRecyclerView.adapter = getView()?.let { ReformCardListAdapter(myReforms(), it.context) }
        myReformsRecyclerView.layoutManager = LinearLayoutManager(getView()?.context)
    }

    private fun myReforms(): List<Reform> {
        return listOf(
            Reform("Reforma 1", reformCategory, productsExact(), store, reformDate),
            Reform("Reforma 2", reformCategory, productsLong(), store, reformDate),
            Reform("Reforma 3", reformCategory, productsShort(), store, reformDate),
            Reform("Reforma 4", reformCategory, productsExact(), store, reformDate),
            Reform("Reforma 5", reformCategory, productsLong(), store, reformDate),
            Reform("Reforma 6", reformCategory, productsShort(), store, reformDate)
        )
    }

    private fun productsShort(): List<Product> {
        return listOf(
            Product("Nome do produto 1", 3.50, 1, "un", "Tok\u0026Stok", 5.0),
            Product("Nome do produto 2", 9.99, 1, "kg", "Leroy Merlin", 4.9),
            Product("Nome do produto 3", 5.75, 1, "litro", "C\u0026C", 4.7)
        )
    }

    private fun productsExact(): List<Product> {
        return listOf(
            Product("Nome do produto 1", 3.50, 1, "un", "Tok\u0026Stok", 5.0),
            Product("Nome do produto 2", 9.99, 1, "kg", "Leroy Merlin", 4.9),
            Product("Nome do produto 3", 5.75, 1, "litro", "C\u0026C", 4.7),
            Product("Nome do produto 4", 7.50, 1, "un", "Telhanorte", 4.9),
            Product("Nome do produto 5", 2.30, 1, "metro", "Dicico", 4.8)
        )
    }

    private fun productsLong(): List<Product> {
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
