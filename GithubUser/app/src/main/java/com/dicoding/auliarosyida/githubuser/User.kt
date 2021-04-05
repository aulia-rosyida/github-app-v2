package com.dicoding.auliarosyida.githubuser

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("login")
    var username: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("location")
    var location: String?,
    @SerializedName("public_repos")
    var repository: String?,
    @SerializedName("company")
    var company: String?,
    @SerializedName("followers")
    var followers: String?,
    @SerializedName("following")
    var following: String?,
    @SerializedName("avatar_url")
    var photo: String?
) : Parcelable