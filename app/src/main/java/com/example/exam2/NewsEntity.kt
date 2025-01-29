package com.example.exam2

import com.google.gson.annotations.SerializedName

data class NewsEntity(
    @SerializedName("pagination") val pagination: Pagination,
    @SerializedName("data") val data: List<Article>
){
    data class Pagination(
        @SerializedName("limit") val limit: Double,
        @SerializedName("offset") val offset: Double,
        @SerializedName("count") val count: Double,
        @SerializedName("total") val total: Double
    )
    data class Article(
        @SerializedName("title") val title: String,
        @SerializedName("description") val description: String,
        @SerializedName("source") val source: String,
        @SerializedName("country") val country:String
    )
}
