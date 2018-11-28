package com.hevadevelop.footballapps.presenter

import com.google.gson.Gson
import com.hevadevelop.footballapps.api.ApiRepository
import com.hevadevelop.footballapps.api.TheSportDb
import com.hevadevelop.footballapps.model.EventsResponse
import com.hevadevelop.footballapps.view.MainView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {
    fun getCompetitionList(typeList: String?, param: String?, valueParam: String?) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam))
                    .await(),
                    EventsResponse::class.java)
            view.showEventList(data.events)
            view.hideLoading()
        }
    }
}