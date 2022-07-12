package com.assembly.client

import com.assembly.model.UserRoot
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StackoverflowClient {

    @GET("users/{userId}?site=stackoverflow")
    Call<UserRoot> user(@Path("userId")Integer userid)

}

