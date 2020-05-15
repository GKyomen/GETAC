package com.ibuild.getac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_edit_personal_info.*

class EditPersonalInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_personal_info)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
            btnSaveAccountInfoChanges.isEnabled = true
        }

    }
}
