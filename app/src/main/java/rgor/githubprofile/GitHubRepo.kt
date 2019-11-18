package rgor.githubprofile

import com.google.gson.annotations.SerializedName

class GitHubRepo(
    @SerializedName("owner")
    val owner : GitHubProfile,
    @SerializedName("html_url")
    val url : String,
    @SerializedName("description")
    val desc : String,
    @SerializedName("pulls_url")
    val pulls : String,
    @SerializedName("name")
    val name: String
)