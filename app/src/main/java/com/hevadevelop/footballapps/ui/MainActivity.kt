package com.hevadevelop.footballapps.ui

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.hevadevelop.footballapps.adapter.TabAdapter
import com.hevadevelop.footballapps.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_main.setupWithViewPager(viewpager_main)
        setupViewPager(viewpager_main)
    }

    private fun setupViewPager(viewPage: ViewPager){
        val tabsAdapter = TabAdapter(supportFragmentManager)
        tabsAdapter.add(LastEvent(), "Last Event")
        tabsAdapter.add(NextEvent(), "Next Event")
        viewPage.adapter = tabsAdapter
    }
}