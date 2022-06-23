package com.assembly.github.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface GitHubClient {

    @GET("users/{user}")
    Call<User> getUser(@Path("user")String user);

}