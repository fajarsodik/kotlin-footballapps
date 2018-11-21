package com.hevadevelop.footballapps.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hevadevelop.footballapps.model.Events
import com.hevadevelop.footballapps.R
import kotlinx.android.synthetic.main.item_match.view.*

class CompetitionAdapter(private val listEvents: List<Events>, private val listenerAdapter: (Events) -> Unit) : RecyclerView.Adapter<CompetitionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false))

    override fun getItemCount(): Int = listEvents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listEvents[position], listenerAdapter)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder (view) {
        fun bindItem(events: Events, listenerAdapter: (Events) -> Unit) {

            itemView.tv_date_match.text = events.eventDate
            itemView.tv_home_team.text = events.homeTeam
            itemView.tv_score_home.text = events.homeScore
            itemView.tv_away_team.text = events.awayTeam
            itemView.tv_score_away.text = events.awayScore
            itemView.item_match_layout.setOnClickListener {
                listenerAdapter(events)
            }
        }
    }
}