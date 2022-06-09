package com.assembly.service


import com.assembly.model.Project
import io.circe.generic.auto._
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import sttp.client3.circe._
import sttp.client3.quick._

trait GitlabService {

  def getLanguages(userName:String): List[String]

}

@Service
class GitlabServiceImpl extends GitlabService {

  @Value("${private-token}")
  var gitlabPrivateToken: String = ""

  def getLanguages(userName:String): List[String] = {

    val request = basicRequest
      .get(uri"https://gitlab.com/api/v4/users/$userName/projects")
      .header("PRIVATE-TOKEN",gitlabPrivateToken)
      .response(asJson[List[Project]])

    val response = request.send(backend)

    if (response.body.isLeft) List()
    else List(response.body.right.get(0).name)
  }


}
