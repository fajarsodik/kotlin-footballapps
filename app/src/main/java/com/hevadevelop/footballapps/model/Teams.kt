package com.hevadevelop.footballapps.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Teams(

        @SerializedName("idTeam")
        var idTeam: String? = null,

        @SerializedName("strTeamBadge")
        var teamBadge: String? = null,

        @SerializedName("strAlternate")
        var teamNameAlternate: String? = null

) : Parcelable