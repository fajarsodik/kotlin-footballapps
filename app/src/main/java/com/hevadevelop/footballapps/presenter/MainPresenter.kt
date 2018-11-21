package com.hevadevelop.footballapps.presenter

import com.google.gson.Gson
import com.hevadevelop.footballapps.api.ApiRepository
import com.hevadevelop.footballapps.api.TheSportDb
import com.hevadevelop.footballapps.model.EventsResponse
import com.hevadevelop.footballapps.view.MainView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {
    fun getCompetitionList(typeList: String?, param: String?, valueParam: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam)),
                    EventsResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventList(data.events)
            }
        }
    }
}