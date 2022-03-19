package com.example.data

import com.example.data.dto.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BaseApi {

    @GET("character/<id:int>")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterDto

    @GET("character")
    suspend fun getCharacterList(@Query("page") pageNum: Int): CharacterListDto

    @GET("episode/<id:int>")
    suspend fun getEpisodeById(@Path("id") id: Int): EpisodeDto

    @GET("episode")
    suspend fun getEpisodeList(@Query("page") pageNum: Int): EpisodeListDto

    @GET("location/<id:int>")
    suspend fun getLocationById(@Path("id") id: Int): LocationDto

    @GET("location")
    suspend fun getLocationList(@Query("page") pageNum: Int): LocationListDto

}