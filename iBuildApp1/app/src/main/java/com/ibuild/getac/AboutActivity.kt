package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibuild.getac.ui.AccountFragment
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        btnBackAccount.setOnClickListener() {
            val intent = Intent(this, AccountFragment::class.java)
            startActivity(intent)
        }
    }

}
