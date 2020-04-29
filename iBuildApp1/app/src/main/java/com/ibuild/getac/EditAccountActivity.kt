package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class EditAccountActivity : AppCompatActivity() {

    private lateinit var editPersonalInfoBtn: LinearLayout
    private lateinit var editPasswordBtn: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_account)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        editPersonalInfoBtn = findViewById(R.id.btnAccountInfo)
        editPasswordBtn = findViewById(R.id.btnAccountPassword)

        editPersonalInfoBtn.setOnClickListener{
            val intent = Intent(this, EditPersonalInfoActivity::class.java)
            startActivity(intent)
        }

        editPasswordBtn.setOnClickListener{
            val intent = Intent(this, EditPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
