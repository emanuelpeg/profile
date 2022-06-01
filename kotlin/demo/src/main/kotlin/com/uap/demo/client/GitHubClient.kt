package com.uap.demo.client

import com.google.gson.JsonObject
import com.uap.demo.model.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubClient {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo?>?>?

    @GET("repos/{user}/{repoName}/languages")
    fun repoLenguages(@Path("user") user: String, @Path("repoName") repoName: String): Call<JsonObject?>?

}