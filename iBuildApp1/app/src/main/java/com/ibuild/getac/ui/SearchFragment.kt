package com.ibuild.getac.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ibuild.getac.LoginActivity
import com.ibuild.getac.R
import com.ibuild.getac.adapter.CategoryCardListAdapter
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val categories: () -> List<String> = { -> listOf(
            "Categoria1",
            "Categoria2",
            "Categoria3",
            "Categoria4",
            "Categoria5",
            "Categoria6",
            "Categoria7",
            "Categoria8",
            "Categoria9",
            "Categoria10",
            "Categoria11",
            "Categoria12",
            "Categoria13",
            "Categoria14",
            "Categoria15",
            "Categoria16"
        )  }

        gridCategory.adapter = getView()?.let {
            CategoryCardListAdapter(categories(), it.context){
                category: String -> run{
                    searchView.setQuery(category, true)
                }
            }
        }

        gridCategory.layoutManager = GridLayoutManager(getView()?.context, 2)

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                val intent = Intent(getView()?.context, LoginActivity::class.java)
                startActivity(intent)
                return false
            }

        })
    }
}
