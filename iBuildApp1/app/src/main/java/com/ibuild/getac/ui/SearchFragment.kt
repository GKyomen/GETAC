package com.ibuild.getac.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.adapter.CategoryCardListAdapter

class SearchFragment : Fragment() {

    private lateinit var grid: RecyclerView
    private lateinit var searchView: SearchView

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
        searchView = getView()?.findViewById(R.id.searchView) as SearchView
        grid = getView()?.findViewById(R.id.gridCategory) as RecyclerView
        grid.adapter = getView()?.let { CategoryCardListAdapter(
            categories(),
            {   /**function onClick**/
                    category: String -> run{
                        searchView.setQuery(category, true)
                    }
            },
            it.context
        ) }
        grid.layoutManager = GridLayoutManager(getView()?.context, 2)
    }
}
