package com.pvsb.core.model

data class IMDBResponse(
    val items: List<IMDBDetails>
)

data class IMDBDetails(
    val title: String,
    val image: String,
    val year: String,
    val imDbRating: String
)
