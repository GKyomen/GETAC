package com.ibuild.getac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibuild.getac.model.ReformCategory
import kotlinx.android.synthetic.main.activity_reform.*

class ReformActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reform)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val reformCategory = intent.getSerializableExtra("CATEGORYREFORM") as ReformCategory
        reformTitle.text = reformCategory.categoryName
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
