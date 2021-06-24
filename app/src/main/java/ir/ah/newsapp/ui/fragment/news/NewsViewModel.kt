package ir.ah.newsapp.ui.fragment.news

import androidx.lifecycle.*
import androidx.paging.*
import dagger.hilt.android.lifecycle.*
import ir.ah.newsapp.base.*
import ir.ah.newsapp.data.model.news.*
import ir.ah.newsapp.data.repository.news.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepositoryImpl):BaseViewModel() {


    @ExperimentalPagingApi
    fun getAllMovie(): Flow<PagingData<Article>> {
        return repository.getTopNews().cachedIn(viewModelScope)
    }
}