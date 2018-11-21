package com.hevadevelop.footballapps.api

import android.net.Uri
import com.hevadevelop.footballapps.BuildConfig

object TheSportDb {

    fun getMatch(typeList: String?, param: String?, valueParam: String?): String {

        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath(typeList)
                .appendQueryParameter(param, valueParam)
                .build()
                .toString()
    }
}