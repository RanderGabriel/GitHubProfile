package rgor.githubprofile

import com.google.gson.annotations.SerializedName

class ReposResponse(
    @SerializedName("incomplete_results")
    val shouldPaginate : Boolean,
    @SerializedName("items")
    val items: List<GitHubRepo>)
