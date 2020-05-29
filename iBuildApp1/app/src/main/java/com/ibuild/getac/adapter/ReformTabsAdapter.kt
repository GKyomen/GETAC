package com.ibuild.getac.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ibuild.getac.reformTabs.*

class ReformTabsAdapter(fragManager: FragmentManager):
    FragmentStatePagerAdapter(fragManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CategoriesFragment()
            1 -> MyReformsFragment()
            2 -> RecommendedFragment()
            else -> TrendingFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Categorias"
            1 -> "Reformas"
            2 -> "Recomendados"
            else -> "Em alta"
        }
    }
}