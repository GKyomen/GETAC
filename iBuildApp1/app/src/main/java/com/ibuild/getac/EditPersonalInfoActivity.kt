package com.ibuild.getac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class EditPersonalInfoActivity : AppCompatActivity() {

    private lateinit var editName: TextInputEditText
    private lateinit var editLastName: TextInputEditText
    private lateinit var editPhone: TextInputEditText
    private lateinit var editEmail: TextInputEditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_personal_info)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        editName        = findViewById(R.id.inputEditName)
        editLastName    = findViewById(R.id.inputEditLastName)
        editPhone       = findViewById(R.id.inputEditPhone)
        editEmail       = findViewById(R.id.inputEditEmail)
        btnSave         = findViewById(R.id.btnSaveAccountInfoChanges)

        editName.addTextChangedListener(enableButtonListener)
        editLastName.addTextChangedListener(enableButtonListener)
        editPhone.addTextChangedListener(enableButtonListener)
        editEmail.addTextChangedListener(enableButtonListener)
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
            btnSave.isEnabled = true
        }

    }
}
