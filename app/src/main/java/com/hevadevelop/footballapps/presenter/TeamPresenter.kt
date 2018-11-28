package com.hevadevelop.footballapps.presenter

import com.google.gson.Gson
import com.hevadevelop.footballapps.api.ApiRepository
import com.hevadevelop.footballapps.api.TheSportDb
import com.hevadevelop.footballapps.model.EventsResponse
import com.hevadevelop.footballapps.model.TeamsResponse
import com.hevadevelop.footballapps.view.DetailMatchView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPresenter(private val view: DetailMatchView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getMatchList(typeList: String?, param: String?, valueParam: String?) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam))
                    .await(),
                    EventsResponse::class.java)
            view.showDetailMatch(data.events)
            view.hideLoading()
        }
//        doAsync {
//            val data = gson.fromJson(apiRepository
//                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam)),
//                    EventsResponse::class.java
//            )
//
//            uiThread {
//                view.hideLoading()
//                view.showDetailMatch(data.events)
//            }
//        }
    }

    fun getHomeDetail(typeList: String?, param: String?, valueParam: String?) {
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam))
                    .await(),
                    TeamsResponse::class.java)
            view.showTeamListHome(data.teams)
            view.hideLoading()
        }
//        doAsync {
//            val data = gson.fromJson(apiRepository
//                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam)),
//                    TeamsResponse::class.java
//            )
//
//            uiThread {
//                view.hideLoading()
//                view.showTeamListHome(data.teams)
//            }
//        }
    }

    fun getAwayDetail(typeList: String?, param: String?, valueParam: String?) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam))
                    .await(),
                    TeamsResponse::class.java)
            view.showTeamListAway(data.teams)
            view.hideLoading()
        }
//        doAsync {
//            val data = gson.fromJson(apiRepository
//                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam)),
//                    TeamsResponse::class.java
//            )
//
//            uiThread {
//                view.hideLoading()
//                view.showTeamListAway(data.teams)
//            }
//        }
    }
}