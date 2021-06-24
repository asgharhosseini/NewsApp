package ir.ah.newsapp.data.repository.news

import androidx.paging.*
import ir.ah.newsapp.data.model.news.*
import ir.ah.newsapp.data.remote.*
import retrofit2.*
import java.io.*
import javax.inject.*


class NewsDataSource @Inject constructor(
    private val apiService: ApiService
) : PagingSource<Int, Article>() {

    private val initialPageIndex: Int = 1
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val position = params.key ?: 1

        try {
            val response = apiService.getTopNews(page = position)

            val resultantItems = response.body()?.articles

            return LoadResult.Page(
                data = resultantItems!!,
                prevKey = if (position == initialPageIndex) null else position - 1,
                nextKey = if (resultantItems.isEmpty()) null else position + 1
            )


        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)

        }
    }
}