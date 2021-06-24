package ir.ah.newsapp.data.local

import androidx.room.*

import ir.ah.newsapp.data.model.news.*
import ir.ah.newsapp.data.model.remotekey.*
import ir.ah.newsapp.other.*


@Database( entities = [Article::class, RemoteKeys::class],version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getRemoteDao(): RemoteKeysDao
    abstract fun getArticleDao(): ArticleDao



}