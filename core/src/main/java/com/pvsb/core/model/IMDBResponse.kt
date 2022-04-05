package com.pvsb.core.model

import com.google.gson.annotations.SerializedName

data class IMDBResponse (
    @SerializedName("Items ")
    val items: List<IMDBDetails>
        )

data class IMDBDetails(
    @SerializedName("Title ")
    val title: String
)
