package ir.ah.newsapp.data.local

import androidx.paging.*
import androidx.room.*
import ir.ah.newsapp.data.model.news.*

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articleList: List<Article>)

    @Query("SELECT * FROM Article")
    fun getAllArticle(): PagingSource<Int, Article>

    @Query("DELETE FROM Article")
    suspend fun clearAllArticle()

}