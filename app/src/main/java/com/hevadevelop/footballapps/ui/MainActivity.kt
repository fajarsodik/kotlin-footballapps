package com.hevadevelop.footballapps.ui

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.hevadevelop.footballapps.adapter.TabAdapter
import com.hevadevelop.footballapps.R
import com.hevadevelop.footballapps.R.id.bm_next_match
import com.hevadevelop.footballapps.R.id.bm_prev_match
import com.hevadevelop.footballapps.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                bm_prev_match -> {
                    loadPrevMatchFragment(savedInstanceState)
                }
                bm_next_match -> {
                    loadNextMatchFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = bm_prev_match
    }

    private fun loadPrevMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, LastEvent(), LastEvent::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, NextEvent(), NextEvent::class.java.simpleName)
                    .commit()
        }
    }
}