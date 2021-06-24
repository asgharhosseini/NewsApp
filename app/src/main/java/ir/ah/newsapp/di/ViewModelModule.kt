package ir.ah.newsapp.di

import androidx.paging.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.components.*
import dagger.hilt.android.scopes.*
import ir.ah.newsapp.data.local.*
import ir.ah.newsapp.data.remote.*
import ir.ah.newsapp.data.repository.news.*


@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {


    @ViewModelScoped
    @Provides
    fun provideNewsRepositoryImpl(apiService: ApiService,appDatabase: AppDatabase) =
        NewsRepositoryImpl(apiService,appDatabase)






}