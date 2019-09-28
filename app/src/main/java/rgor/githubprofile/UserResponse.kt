package rgor.githubprofile

import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("items")
    lateinit var users : List<GitHubProfile>
}
