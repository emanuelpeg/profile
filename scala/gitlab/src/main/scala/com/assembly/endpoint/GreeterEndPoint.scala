package com.assembly.endpoint

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod, RestController}

@RestController
@RequestMapping(Array("/v1"))
class GreeterEndPoint {

  @RequestMapping(value=Array("/hello/{name}"), method = Array(RequestMethod.GET))
  def sayHello(@PathVariable(name = "name") name:String): ResponseEntity[String] =
    ResponseEntity.ok(s"Hello ${name}")

}
