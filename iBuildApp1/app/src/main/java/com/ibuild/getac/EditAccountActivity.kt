package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_account.*

class EditAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_account)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnAccountInfo.setOnClickListener{
            val intent = Intent(this, EditPersonalInfoActivity::class.java)
            startActivity(intent)
        }

        btnAccountPassword.setOnClickListener{
            val intent = Intent(this, EditPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
