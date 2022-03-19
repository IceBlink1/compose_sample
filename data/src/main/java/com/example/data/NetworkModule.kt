package com.example.data

import com.example.data.repository.*
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApi(): BaseApi {
        return buildApi(BaseApi::class.java)
    }

    @Provides
    fun bindsCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRepository {
        return characterRepositoryImpl
    }

    @Provides
    fun bindsEpisodeRepository(characterRepositoryImpl: EpisodeRepositoryImpl): EpisodeRepository {
        return characterRepositoryImpl
    }

    @Provides
    fun bindsLocationRepository(characterRepositoryImpl: LocationRepositoryImpl): LocationRepository {
        return characterRepositoryImpl
    }

    fun <Api> buildApi(
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().create()
                )
            )
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }).build())
            .build()
            .create(api)
    }

    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/api/"
    }

}