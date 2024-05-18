package com.example.tiptime.network

import com.example.tiptime.model.Question
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api.php?amount=10")
    suspend fun getQuestions(
        @Query("category") type: Int,
        @Query("difficulty") difficulty: String
    ): Question


    companion object {
        private var apiService: ApiService? = null

        fun getInstance(): ApiService {
            if (apiService == null) {

                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)

                val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()

                apiService = Retrofit.Builder()
                    .baseUrl("https://opentdb.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}
