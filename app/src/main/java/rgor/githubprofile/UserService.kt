package rgor.githubprofile

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("/search/users")
    fun query(@Query("q") q: String) : Call<UserResponse>
}