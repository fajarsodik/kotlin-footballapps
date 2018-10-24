package com.hevadevelop.footballclub.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.hevadevelop.footballclub.listView.ItemViewClub
import com.hevadevelop.footballclub.model.TeamModel
import org.jetbrains.anko.AnkoContext

class TeamAdapter (var list: MutableList<TeamModel>, var listener: (TeamModel) -> Unit) : RecyclerView.Adapter<TeamAdapter.TeamAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapterViewHolder {
        return TeamAdapterViewHolder(ItemViewClub().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TeamAdapterViewHolder, position: Int) {
        holder.bindItem(list[position], listener)
    }


    inner class TeamAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView : ImageView
        var textView : TextView

        init {
            imageView = itemView.findViewById(ItemViewClub.imageId)
            textView = itemView.findViewById(ItemViewClub.nameId)
        }

        fun bindItem (items : TeamModel, listener : (TeamModel) -> Unit){
            textView.text = items.name
            Glide.with(itemView.context).load(items.image).into(imageView)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}