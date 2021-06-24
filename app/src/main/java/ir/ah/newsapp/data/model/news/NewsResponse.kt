package ir.ah.newsapp.data.model.news


import com.google.gson.annotations.SerializedName

import android.os.Parcelable
import kotlinx.android.parcel.*

@Parcelize
data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
) : Parcelable