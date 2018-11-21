package com.hevadevelop.footballapps.view

import com.hevadevelop.footballapps.model.Events
import com.hevadevelop.footballapps.model.Teams

interface TeamView {

    fun showLoading()
    fun hideLoading()
    fun showDetailMatch(data: List<Events>?)
    fun showTeamListHome(data: List<Teams>?)
    fun showTeamListAway(data: List<Teams>?)
}