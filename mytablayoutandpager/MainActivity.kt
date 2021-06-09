package com.example.mytablayoutandpager

import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val pagerAdapter = PagerAdapter(supportFragmentManager, 3)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }
}

class PagerAdapter(
    val fragmentManager: FragmentManager,
    val tabCount: Int
) : FragmentStatePagerAdapter(fragmentManager, tabCount) {

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Fragment0()
            }
            1 -> {
                return Fragment1()
            }
            2 -> {
                return Fragment2()
            }
            else -> return Fragment0()
        }
    }
}