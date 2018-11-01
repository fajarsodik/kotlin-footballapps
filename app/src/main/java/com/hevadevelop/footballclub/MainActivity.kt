package com.hevadevelop.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.hevadevelop.footballclub.adapter.TeamAdapter
import com.hevadevelop.footballclub.model.TeamModel
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    var clubItem : MutableList<TeamModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()

        linearLayout{
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = TeamAdapter(clubItem) {
                    startActivity<DetailTeam>("name" to it.name, "image" to it.image, "detail" to it.detail)
                }
            }
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val detail = resources.getStringArray(R.array.club_detail)

        clubItem.clear()

        for (i in name.indices) {
            clubItem.add(TeamModel(name[i], image.getResourceId(i, 0), detail[i]))
        }

        image.recycle()
    }
}
//TODO: https://thesportsdb.com/ untuk api submission 2

