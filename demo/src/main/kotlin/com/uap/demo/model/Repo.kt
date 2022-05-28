package com.uap.demo.model

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String,
    @SerializedName("full_name")
    var fullName: String,
    @SerializedName("language")
    var language: String,
    @SerializedName("url")
    var url: String
) {}