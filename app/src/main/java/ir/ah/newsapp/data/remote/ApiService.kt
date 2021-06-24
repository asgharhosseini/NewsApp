package ir.ah.newsapp.data.remote

import ir.ah.newsapp.data.model.news.*
import retrofit2.*
import retrofit2.http.*

interface ApiService {

    @GET("top-headlines")
suspend fun getTopNews(
        @Query("country")country:String="us",
        @Query("page")page:Int,
        @Query("pagesize")pageSize:Int=5,
        @Query("apiKey")apiKey: String= "fb6aded56f7e4445a963d794dceb4ab1"
    ) :Response<NewsResponse>
}