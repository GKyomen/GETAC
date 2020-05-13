package com.ibuild.getac.reformTabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.adapter.CategoryListAdapter
import com.ibuild.getac.model.Category

class CategoriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = getView()?.findViewById(R.id.categoryListRecyclerView) as RecyclerView
        recyclerView.adapter = getView()?.let { CategoryListAdapter(categories(), it.context) }
        recyclerView.layoutManager = GridLayoutManager(getView()?.context, 2)
    }

    private fun categories() : List<Category> {
        return listOf(
            Category("Banheiro"),
            Category("Sala"),
            Category("Quarto"),
            Category("Cozinha"),
            Category("Lavanderia"),
            Category("Varanda"),
            Category("Quintal"),
            Category("Lazer"),
            Category("Porão"),
            Category("Sótão")
        )
    }
}
