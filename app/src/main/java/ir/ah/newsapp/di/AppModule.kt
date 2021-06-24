package ir.ah.newsapp.di

import android.content.*
import androidx.room.*
import com.bumptech.glide.*
import com.bumptech.glide.load.engine.*
import com.bumptech.glide.load.resource.bitmap.*

import com.bumptech.glide.request.*
import com.google.gson.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.qualifiers.*
import dagger.hilt.components.*
import ir.ah.newsapp.*
import ir.ah.newsapp.R
import ir.ah.newsapp.data.local.*
import ir.ah.newsapp.data.remote.*
import retrofit2.*
import retrofit2.converter.gson.*
import javax.inject.*


@Module
@InstallIn(SingletonComponent::class)
 object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app_db"
        ).allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideArticleDao(appDatabase: AppDatabase): ArticleDao {
        return appDatabase.getArticleDao()
    }
    @Provides
    fun provideRemoteKeysDao(appDatabase: AppDatabase): RemoteKeysDao {
        return appDatabase.getRemoteDao()
    }



    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions().placeholder(R.drawable.ic_error_logo)
            .error(R.drawable.ic_error_logo)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(16)))
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )


    @Provides
    @Singleton
     fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Singleton
    @Provides
    fun provideApiService(gson: Gson): ApiService =
        Retrofit.Builder()
            .baseUrl(EndPoint.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)

}