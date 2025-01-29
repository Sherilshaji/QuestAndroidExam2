package com.example.exam2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {
    suspend fun getCurrencyInfo(
        sources: String,
        country: String
    ): List<NewsModel> {
        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(NewsApi::class.java)
        return api.getNewsDetails(Constants.API_KEY,sources,country).toNewsModel()
    }
}
fun NewsEntity.toNewsModel(): List<NewsModel> {
    return this.data.map { article ->
        NewsModel(
            newsTitle = article.title,
            newsDescription = article.description,
            source = article.source
        )
    }
}
