package rgor.githubprofile

import com.google.gson.annotations.SerializedName

class GitHubProfile(
    @SerializedName("login")
    val name : String,
    val repoCount : Number = 1,
    @SerializedName("avatar_url")
    val pictureUrl : String)
