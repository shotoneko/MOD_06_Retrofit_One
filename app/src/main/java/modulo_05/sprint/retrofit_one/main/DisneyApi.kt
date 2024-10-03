package modulo_05.sprint.retrofit_one.main

import android.util.Log

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface DisneyApi {
    companion object {
        val instance: DisneyApi = Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
                OkHttpClient.Builder().build()
            )
            .build()
            .create(DisneyApi::class.java)
    }
    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}

