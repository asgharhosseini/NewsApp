package ir.ah.newsapp.data.model.news


import com.google.gson.annotations.SerializedName

import android.os.Parcelable
import kotlinx.android.parcel.*

@Parcelize
data class Source(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
) : Parcelable