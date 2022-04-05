package com.pvsb.core.model

import com.google.gson.annotations.SerializedName

data class IMDBResponse(
    @SerializedName("items")
    val items: List<IMDBDetails>
)

data class IMDBDetails(
    @SerializedName("title")
    val title: String
)
