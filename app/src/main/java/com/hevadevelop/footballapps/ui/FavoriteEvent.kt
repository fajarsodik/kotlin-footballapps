package com.hevadevelop.footballapps.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hevadevelop.footballapps.R
import com.hevadevelop.footballapps.adapter.FavoriteMatchAdapter
import com.hevadevelop.footballapps.db.FavoriteMatch
import com.hevadevelop.footballapps.db.database
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class FavoriteEvent : Fragment(){

    private var favoritesMatch: MutableList<FavoriteMatch> = mutableListOf()
    private lateinit var adapter: FavoriteMatchAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = FavoriteMatchAdapter(favoritesMatch) {
            context?.startActivity<DetailMatch>("eventId" to it.matchId, "homeTeamId" to it.teamHomeId, "awayTeamId" to it.teamAwayId)
        }

        recycler_favorite.adapter = adapter
        recycler_favorite.layoutManager = LinearLayoutManager(context)
        swipe_refresh_favorite.onRefresh {
            showFavoriteMatch()
        }
    }

    override fun onResume() {
        super.onResume()
        showFavoriteMatch()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    private fun showFavoriteMatch() {
        favoritesMatch.clear()
        context?.database?.use {
            swipe_refresh_favorite.isRefreshing = false
            val result = select(FavoriteMatch.TABLE_FAVORITE_MATCH)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            favoritesMatch.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }
}
