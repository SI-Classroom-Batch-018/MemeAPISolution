package de.syntax_institut.funappsvorlage.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntax_institut.funappsvorlage.data.model.MemeResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.imgflip.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface MemeApiService {

    @GET("get_memes")
    suspend fun getMemes(): MemeResponse
}

object MemeAPI {
    val service: MemeApiService by lazy { retrofit.create(MemeApiService::class.java) }
}