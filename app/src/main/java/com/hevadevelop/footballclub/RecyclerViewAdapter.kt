package com.hevadevelop.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nama = view.findViewById<TextView>(R.id.nama_klub)
        private val image = view.findViewById<ImageView>(R.id.image_club)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            nama.text = items.name
            items.image?.let { Picasso.get().load(it).into(image) }
            itemView.setOnClickListener { listener(items) }
        }
    }

}