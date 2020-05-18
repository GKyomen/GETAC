package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener(mainIntent)
        btnLoginGoogle.setOnClickListener(mainIntent)
        btnRegisterLogin.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnForgotPassword.setOnClickListener {
            val intent = Intent(this, EditPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private val mainIntent = View.OnClickListener{
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
