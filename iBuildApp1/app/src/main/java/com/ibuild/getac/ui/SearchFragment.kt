package com.ibuild.getac.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.adapter.CategoryCardListAdapter
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var grid: RecyclerView

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
            "Categoria8"
        )  }
        grid = getView()?.findViewById(R.id.gridCategory) as RecyclerView
        grid.adapter = getView()?.let { CategoryCardListAdapter(categories(), it.context) }
        grid.layoutManager = GridLayoutManager(getView()?.context, 2)
    }


}
