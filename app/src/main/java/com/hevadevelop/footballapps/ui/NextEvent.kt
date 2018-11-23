package com.hevadevelop.footballapps.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.hevadevelop.footballapps.adapter.CompetitionAdapter
import com.hevadevelop.footballapps.api.ApiRepository
import com.hevadevelop.footballapps.model.Events
import com.hevadevelop.footballapps.presenter.MainPresenter
import com.hevadevelop.footballapps.R
import com.hevadevelop.footballapps.util.invisible
import com.hevadevelop.footballapps.util.visible
import com.hevadevelop.footballapps.view.MainView
import kotlinx.android.synthetic.main.fragment_match.*
import org.jetbrains.anko.support.v4.startActivity

class NextEvent: Fragment(), MainView {

    private var eventsList: MutableList<Events> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: CompetitionAdapter
    private lateinit var typeList: String
    private lateinit var param: String
    private lateinit var valueParam: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val request = ApiRepository()
        val gson = Gson()
        typeList = "eventsnextleague.php"
        param = "id"
        valueParam = "4328"

        presenter = MainPresenter(this, request, gson)
        presenter.getCompetitionList(typeList, param, valueParam)

        adapter = CompetitionAdapter(eventsList) {
            startActivity<DetailMatch>("eventId" to it.eventId, "homeTeamId" to it.idHomeTeam, "awayTeamId" to it.idAwayTeam)
        }

        recycler_match.adapter = adapter
        recycler_match.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()
        eventsList.clear()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun showLoading() {
        progress_match?.visible()
    }

    override fun hideLoading() {
        progress_match?.invisible()
    }

    override fun showEventList(data: List<Events>?) {
        eventsList.clear()
        data?.let {
            eventsList.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }
}