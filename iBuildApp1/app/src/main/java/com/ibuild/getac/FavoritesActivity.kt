package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibuild.getac.adapter.FavoriteStoreListAdapter
import com.ibuild.getac.model.Store
import kotlinx.android.synthetic.main.activity_favorites.*

class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        favoriteStoreList.adapter = FavoriteStoreListAdapter(stores(), {
            val intent = Intent(this, StoreActivity::class.java)
            intent.putExtra("STORE", it)
            startActivity(intent)
        }, this)
        favoriteStoreList.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
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
