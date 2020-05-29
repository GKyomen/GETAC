package com.ibuild.getac.reformTabs

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.ibuild.getac.R
import com.ibuild.getac.ReformActivity
import com.ibuild.getac.adapter.CategoryListAdapter
import com.ibuild.getac.model.ReformCategory
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryListRecyclerView.adapter = getView()?.let { it ->
            CategoryListAdapter(categories(), {
                val intent = Intent(activity, ReformActivity::class.java)
                intent.putExtra("CATEGORYREFORM", it)
                startActivity(intent)
        },it.context) }
        categoryListRecyclerView.layoutManager = GridLayoutManager(getView()?.context, 2)
    }

    private fun categories() : List<ReformCategory> {
        return listOf(
            ReformCategory("Banheiro"),
            ReformCategory("Sala"),
            ReformCategory("Quarto"),
            ReformCategory("Cozinha"),
            ReformCategory("Lavanderia"),
            ReformCategory("Varanda"),
            ReformCategory("Quintal"),
            ReformCategory("Lazer"),
            ReformCategory("Porão"),
            ReformCategory("Sótão")
        )
    }
}
