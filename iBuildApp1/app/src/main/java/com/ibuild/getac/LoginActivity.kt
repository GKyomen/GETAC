package com.ibuild.getac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.ibuild.getac.ui.HomeFragment
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var btnLoginGoogle: Button
    private lateinit var btnRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin        = findViewById(R.id.btnLogin)
        btnLoginGoogle  = findViewById(R.id.btnLoginGoogle)
        btnRegister     = findViewById(R.id.btnRegisterLogin)


        btnLogin.setOnClickListener(mainIntent)
        btnLoginGoogle.setOnClickListener(mainIntent)
        btnRegister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnForgotPassword.setOnClickListener {
            val intent = Intent(this, EditPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private val mainIntent = View.OnClickListener{
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
