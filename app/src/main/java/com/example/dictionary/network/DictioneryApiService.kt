package com.example.dictionary.network

import com.example.dictionary.model.DictionaryViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path


private const val URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"


private val json = Json {
    ignoreUnknownKeys = true
}




private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(URL)
    .build()



interface DictionaryApiService {
    @GET("{word}")
    suspend fun getMeaning(@Path("word") word: String): List<WordData>
}

object DictionaryApi {
    val retrofitService : DictionaryApiService by lazy {
        retrofit.create(DictionaryApiService::class.java)
    }
}