package com.hevadevelop.footballapps.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hevadevelop.footballapps.R
import com.hevadevelop.footballapps.db.FavoriteMatch
import kotlinx.android.synthetic.main.item_match.view.*

class FavoriteMatchAdapter(private val listFavoriteMatch: List<FavoriteMatch>, private val listenerAdapter: (FavoriteMatch) -> Unit)
    : RecyclerView.Adapter<FavoriteMatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false))

    override fun getItemCount(): Int = listFavoriteMatch.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listFavoriteMatch[position], listenerAdapter)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(favoriteMatch: FavoriteMatch, listenerAdapter: (FavoriteMatch) -> Unit) {
            itemView.tv_date_match.text = favoriteMatch.dateMatch
            itemView.tv_home_team.text = favoriteMatch.teamHomeName
            itemView.tv_score_home.text = favoriteMatch.teamHomeScore
            itemView.tv_away_team.text = favoriteMatch.teamAwayName
            itemView.tv_score_away.text = favoriteMatch.teamAwayScore
//            favoriteMatch.teamAwayScore
            itemView.item_match_layout.setOnClickListener {
                listenerAdapter(favoriteMatch)
            }
        }
    }

}