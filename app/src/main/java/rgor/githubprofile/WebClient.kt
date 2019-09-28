package rgor.githubprofile

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebClient {
    private val client = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun userService(): UserService = client.create(UserService::class.java)
}