package com.ibuild.getac.reformTabs

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.R
import com.ibuild.getac.StoreActivity
import com.ibuild.getac.adapter.StoreCardListAdapter
import com.ibuild.getac.model.Store
import kotlinx.android.synthetic.main.fragment_recommended.*

class RecommendedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recommended, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recommendedListRecyclerView.adapter = getView()?.let { it ->
            StoreCardListAdapter(stores(), {
                val intent = Intent(activity, StoreActivity::class.java)
                intent.putExtra("STORE", it)
                startActivity(intent)
            }, it.context)
        }
        recommendedListRecyclerView.layoutManager = LinearLayoutManager(getView()?.context)
    }

    private fun stores() : List<Store> {
        return listOf(
            Store("Nome do estabelecimento 1", "Nome da rua - Cidade 1", 4.8),
            Store("Nome do estabelecimento 2", "Nome da rua - Cidade 2", 4.7),
            Store("Nome do estabelecimento 3", "Nome da rua - Cidade 3", 4.5),
            Store("Nome do estabelecimento 4", "Nome da rua - Cidade 4", 4.9),
            Store("Nome do estabelecimento 5", "Nome da rua - Cidade 5", 5.0)
        )
    }
}
