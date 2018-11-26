package com.hevadevelop.footballapps.presenter

import com.google.gson.Gson
import com.hevadevelop.footballapps.api.ApiRepository
import com.hevadevelop.footballapps.api.TheSportDb
import com.hevadevelop.footballapps.model.EventsResponse
import com.hevadevelop.footballapps.model.TeamsResponse
import com.hevadevelop.footballapps.view.DetailMatchView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPresenter(private val view: DetailMatchView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getMatchList(typeList: String?, param: String?, valueParam: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam)),
                    EventsResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showDetailMatch(data.events)
            }
        }
    }

    fun getHomeDetail(typeList: String?, param: String?, valueParam: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam)),
                    TeamsResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamListHome(data.teams)
            }
        }
    }

    fun getAwayDetail(typeList: String?, param: String?, valueParam: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDb.getMatch(typeList, param, valueParam)),
                    TeamsResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamListAway(data.teams)
            }
        }
    }
}