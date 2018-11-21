package com.hevadevelop.footballapps.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Events(

        @SerializedName("idEvent")
        var eventId: String? = null,

        @SerializedName("dateEvent")
        var eventDate: String? = null,

        @SerializedName("idHomeTeam")
        var idHomeTeam: String? = null,

        @SerializedName("strHomeTeam")
        var homeTeam: String? = null,

        @SerializedName("intHomeScore")
        var homeScore: String? = null,

        @SerializedName("strHomeGoalDetails")
        var homeGoalDetail: String? = null,

        @SerializedName("intHomeShots")
        var homeShots: String? = null,

        @SerializedName("strHomeRedCards")
        var homeRedCards: String? = null,

        @SerializedName("strHomeYellowCards")
        var homeYellowCards: String? = null,

        @SerializedName("strHomeLineupGoalkeeper")
        var homeLineupGoalKeeper: String? = null,

        @SerializedName("strHomeLineupDefense")
        var homeLineupDefense: String? = null,

        @SerializedName("strHomeLineupMidfield")
        var homeLineupMidfield: String? = null,

        @SerializedName("strHomeLineupForward")
        var homeLineupForward: String? = null,

        @SerializedName("strHomeLineupSubstitutes")
        var homeLineupSubstitutes: String? = null,

        @SerializedName("idAwayTeam")
        var idAwayTeam: String? = null,

        @SerializedName("strAwayTeam")
        var awayTeam: String? = null,

        @SerializedName("intAwayScore")
        var awayScore: String? = null,

        @SerializedName("strAwayGoalDetails")
        var awayGoalDetail: String? = null,

        @SerializedName("intAwayShots")
        var awayShots: String? = null,

        @SerializedName("strAwayRedCards")
        var awayRedCards: String? = null,

        @SerializedName("strAwayYellowCards")
        var awayYellowCards: String? = null,

        @SerializedName("strAwayLineupGoalkeeper")
        var awayLineupGoalKeeper: String? = null,

        @SerializedName("strAwayLineupDefense")
        var awayLineupDefense: String? = null,

        @SerializedName("strAwayLineupMidfield")
        var awayLineupMidfield: String? = null,

        @SerializedName("strAwayLineupForward")
        var awayLineupForward: String? = null,

        @SerializedName("strAwayLineupSubstitutes")
        var awayLineupSubstitutes: String? = null


) : Parcelable