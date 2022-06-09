package com.assembly.service

import com.assembly.client.GitLabClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import scala.collection.JavaConverters._

trait GitlabService {

  def getLanguages(userName:String): List[String]

}

@Service
class GitlabServiceImpl extends GitlabService {

  @Value("${private-token}")
  var gitlabPrivateToken: String = ""

  val retrofit = new Retrofit.Builder()
    .baseUrl("https://gitlab.com/api/v4/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

  val gitLabClient = retrofit.create(classOf[GitLabClient])

  def getLanguages(userName:String): List[String] = {
    gitLabClient.projects(gitlabPrivateToken, userName).execute().body().asScala.flatMap(
      p => gitLabClient.projectLenguages(gitlabPrivateToken,p.id).execute().body().keySet().asScala
    ).distinct.toList

  }


}
