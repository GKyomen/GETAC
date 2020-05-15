package com.ibuild.getac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class EditPasswordActivity : AppCompatActivity() {

    private lateinit var oldPassword: TextInputEditText
    private lateinit var editPassword: TextInputEditText
    private lateinit var editPasswordConfirm: TextInputEditText
    private lateinit var btnSavePass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_password)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        oldPassword         = findViewById(R.id.inputOldPassword)
        editPassword        = findViewById(R.id.inputEditPassword)
        editPasswordConfirm = findViewById(R.id.inputEditPasswordConfirm)
        btnSavePass         = findViewById(R.id.btnSavePasswordChanges)

        oldPassword.addTextChangedListener(enableButtonListener)
        editPassword.addTextChangedListener(enableButtonListener)
        editPasswordConfirm.addTextChangedListener(enableButtonListener)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private val enableButtonListener = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btnSavePass.isEnabled = true
        }

    }
}
