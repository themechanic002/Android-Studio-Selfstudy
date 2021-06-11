package com.example.mytablayoutandpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        val adapter = Adapter(LayoutInflater.from(this@MainActivity))
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }
}

class Adapter(
        val layoutInflater: LayoutInflater
): PagerAdapter(){


    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when (position) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.item0, container, false)
                container.addView(view)
                return view
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.item1, container, false)
                container.addView(view)
                return view
            }
            2 -> {
                val view = layoutInflater.inflate(R.layout.item2, container, false)
                container.addView(view)
                return view
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.item0, container, false)
                container.addView(view)
                return view
            }
        }
    }
}