package com.hevadevelop.footballapps.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.gson.Gson
import com.hevadevelop.footballapps.api.ApiRepository
import com.hevadevelop.footballapps.model.Events
import com.hevadevelop.footballapps.model.Teams
import com.hevadevelop.footballapps.presenter.TeamPresenter
import com.hevadevelop.footballapps.R
import com.hevadevelop.footballapps.R.layout.activity_detail_match
import com.hevadevelop.footballapps.util.invisible
import com.hevadevelop.footballapps.util.visible
import com.hevadevelop.footballapps.view.TeamView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatch : AppCompatActivity(), TeamView {

    private var eventsList: MutableList<Events> = mutableListOf()
    private var teamHomeList: MutableList<Teams> = mutableListOf()
    private var teamAwayList: MutableList<Teams> = mutableListOf()
    private lateinit var presenter: TeamPresenter
    private lateinit var typeList: String
    private lateinit var param: String
    private lateinit var valueParam: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_detail_match)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        typeList = "lookupevent.php"
        param = "id"

        val request = ApiRepository()
        val gson = Gson()
        val intent = intent
        valueParam = intent.getStringExtra("eventId")

        presenter = TeamPresenter(this, request, gson)

        presenter.getMatchList(typeList, param, valueParam)

        typeList = "lookupteam.php"
        param = "id"
        valueParam = intent.getStringExtra("homeTeamId")

        presenter.getHomeDetail(typeList, param, valueParam)

        typeList = "lookupteam.php"
        param = "id"
        valueParam = intent.getStringExtra("awayTeamId")

        presenter.getAwayDetail(typeList, param, valueParam)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    override fun showLoading() {
        Log.d("loading", "Loading")
        progress_match.visible()
    }

    override fun hideLoading() {
        Log.d("loading", "Loading")
        progress_match.invisible()
    }

    override fun showDetailMatch(data: List<Events>?) {
        eventsList.clear()
        data?.let {
            eventsList.addAll(data)
        }

        for (i in eventsList.indices) {
            tv_date_detail_match.text = eventsList[i].eventDate
            tv_score_home_detail.text = eventsList[i].homeScore
            tv_score_away_detail.text = eventsList[i].awayScore
            tv_team_home_detail.text = eventsList[i].homeTeam
            tv_team_away_detail.text = eventsList[i].awayTeam
            tv_goal_home.text = eventsList[i].homeGoalDetail?.replace(";", "\n")
            tv_goal_away.text = eventsList[i].awayGoalDetail?.replace(";", "\n")
            tv_shots_home.text = eventsList[i].homeShots
            tv_shots_away.text = eventsList[i].awayShots
            tv_gk_home.text = eventsList[i].homeLineupGoalKeeper?.replace(";", "\n")
            tv_gk_away.text = eventsList[i].awayLineupGoalKeeper?.replace(";", "\n")
            tv_defense_home.text = eventsList[i].homeLineupDefense?.replace(";", "\n")
            tv_defense_away.text = eventsList[i].awayLineupDefense?.replace(";", "\n")
            tv_midfield_home.text = eventsList[i].homeLineupMidfield?.replace(";", "\n")
            tv_midfield_away.text = eventsList[i].awayLineupMidfield?.replace(";", "\n")
            tv_forward_home.text = eventsList[i].homeLineupForward?.replace(";", "\n")
            tv_forward_away.text = eventsList[i].awayLineupForward?.replace(";", "\n")
            tv_substitutes_home.text = eventsList[i].homeLineupSubstitutes?.replace(";", "\n")
            tv_substitutes_away.text = eventsList[i].awayLineupSubstitutes?.replace(";", "\n")
        }
    }

    override fun showTeamListHome(data: List<Teams>?) {
        teamHomeList.clear()
        data?.let {
            teamHomeList.addAll(data)
        }

        for (i in teamHomeList.indices) {
            Picasso.get().load(teamHomeList[i].teamBadge).into(iv_home_badge)
        }
    }

    override fun showTeamListAway(data: List<Teams>?) {
        teamAwayList.clear()
        data?.let {
            teamAwayList.addAll(data)
        }

        for (i in teamAwayList.indices) {
            Picasso.get().load(teamAwayList[i].teamBadge).into(iv_away_badge)
        }
    }

}
