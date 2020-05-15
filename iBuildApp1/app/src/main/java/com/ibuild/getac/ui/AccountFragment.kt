package com.ibuild.getac.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ibuild.getac.EditAccountActivity
import com.ibuild.getac.LoginActivity
import com.ibuild.getac.R
import com.ibuild.getac.SettingsActivity
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* TO DO: sem tela de favoritos ainda
        FavAccountLayout.setOnClickListener{
            val intent = Intent(activity, Main::class.java)
            activity?.startActivity(intent)
        }
        */
        SettingsAccountLayout.setOnClickListener{
            val intent = Intent (activity, SettingsActivity::class.java)
            activity?.startActivity(intent)
        }
        EditAccountLayout.setOnClickListener{
            val intent = Intent (activity, EditAccountActivity::class.java)
            activity?.startActivity(intent)
        }
        LogoutAccountLayout.setOnClickListener{
            val intent = Intent (activity, LoginActivity::class.java)
            activity?.startActivity(intent)
            activity?.finish()
        }
    }
}
