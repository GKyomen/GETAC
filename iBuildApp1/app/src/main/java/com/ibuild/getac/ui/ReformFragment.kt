package com.ibuild.getac.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ibuild.getac.R
import com.ibuild.getac.adapter.ReformTabsAdapter
import kotlinx.android.synthetic.main.fragment_reform.*

class ReformFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reform, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentAdapter = ReformTabsAdapter(parentFragmentManager)
        viewPager.adapter = fragmentAdapter
        reformTabs.setupWithViewPager(viewPager)
    }
}
