package com.assembly.endpoint

import com.assembly.service.GitlabService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod, RestController}
import scala.collection.JavaConverters._

@RestController
@RequestMapping(Array("/v1/gitlab"))
class GitlabLanguajesEndPoint(@Autowired val gitlabService : GitlabService) {

  @RequestMapping(value=Array("/{userName}/languages"), method = Array(RequestMethod.GET))
  def getLanguages(@PathVariable(name = "userName") userName:String): ResponseEntity[java.util.List[String]] =
    ResponseEntity.ok(gitlabService.getLanguages(userName).asJava)

}
