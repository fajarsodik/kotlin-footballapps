package com.hevadevelop.footballapps.view

import com.hevadevelop.footballapps.model.Events

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Events>?)
}