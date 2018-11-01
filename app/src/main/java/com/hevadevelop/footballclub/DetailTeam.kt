package com.hevadevelop.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.viewPager

class DetailTeam : AppCompatActivity() {

    private var nameIntent: String = ""
    private var imageIntent: Int = 0
    private var detailIntent: String = ""

    lateinit var nameClub: TextView
    lateinit var imageClub: ImageView
    lateinit var detailClub: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout{
            orientation = LinearLayout.VERTICAL

            padding = dip(16)

            imageClub = imageView {
                this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
            }.lparams(width = dip(100), height = dip(100))

            nameClub = textView {
                gravity = Gravity.CENTER
            }

            detailClub = textView {
                topPadding = dip (10)
            }
        }

        val intent = intent
        nameIntent = intent.getStringExtra("name")
        imageIntent = intent.getIntExtra("image", 1)
        detailIntent = intent.getStringExtra("detail")

        nameClub.text = nameIntent
        detailClub.text = detailIntent
        Glide.with(this).load(imageIntent).into(imageClub)
    }
}
