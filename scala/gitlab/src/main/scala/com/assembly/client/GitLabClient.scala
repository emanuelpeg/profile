package com.assembly.client

import com.assembly.model.Project
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.{GET, Header, Path}

trait GitLabClient {

  @GET("users/{user}/projects")
  def projects(@Header("PRIVATE-TOKEN") token:String,
               @Path("user") user: String): Call[java.util.List[Project]]

  @GET("projects/{projectId}/languages")
  def projectLenguages(@Header("PRIVATE-TOKEN") token:String,
                       @Path("projectId") projectId: String): Call[JsonObject]

}
