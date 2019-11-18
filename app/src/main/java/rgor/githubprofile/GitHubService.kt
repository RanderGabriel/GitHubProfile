package rgor.githubprofile

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {
    @GET("/search/users")
    fun queryUsers(@Query("q") q: String) : Call<UserResponse>
    @GET("/search/repositories")
    fun queryRepositories(@Query("q") q: String, @Query("page") page: Number) : Call<ReposResponse>
}