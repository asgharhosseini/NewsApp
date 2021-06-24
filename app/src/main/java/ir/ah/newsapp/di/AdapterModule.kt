package ir.ah.newsapp.di

import com.bumptech.glide.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.components.*
import dagger.hilt.components.*
import ir.ah.newsapp.ui.adapter.*

@Module
@InstallIn(SingletonComponent::class)
object AdapterModule {

    @Provides
    fun provideNewsAdapter(glide: RequestManager) = NewsAdapter(glide)

}