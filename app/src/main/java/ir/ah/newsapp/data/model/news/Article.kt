package ir.ah.newsapp.data.model.news


import android.os.*
import androidx.room.*
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.*



@Parcelize
@Entity
data class Article(
    @PrimaryKey(autoGenerate =true)
    @SerializedName("id")
    val id:Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String
) : Parcelable