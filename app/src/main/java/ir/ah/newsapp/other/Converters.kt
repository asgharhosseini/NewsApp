package ir.ah.newsapp.other

import androidx.room.*
import ir.ah.newsapp.data.model.news.*

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}