package ir.ah.newsapp.data.repository.news

import androidx.paging.*
import ir.ah.newsapp.data.local.*
import ir.ah.newsapp.data.model.news.*
import ir.ah.newsapp.data.remote.*
import kotlinx.coroutines.flow.*
import javax.inject.*


class NewsRepositoryImpl
@Inject constructor(
    private val api: ApiService,
    private val appDatabase: AppDatabase
) {

    @ExperimentalPagingApi
    fun getTopNews()= Pager(
        config = PagingConfig(
            pageSize = 5
        ), pagingSourceFactory = {
            NewsDataSource(api)

        }).flow


   /* @OptIn(ExperimentalPagingApi::class)
    fun getTopNews():Flow<PagingData<Article>> {
        if (appDatabase == null) throw IllegalStateException("Database is not initialized")
        val pagingSourceFactory = { appDatabase.getArticleDao().getAllArticle() }
      return  Pager(
            config = PagingConfig(pageSize = 5),
          pagingSourceFactory = pagingSourceFactory,
          remoteMediator = NewsMediator(api, appDatabase)).flow
    }*/







}