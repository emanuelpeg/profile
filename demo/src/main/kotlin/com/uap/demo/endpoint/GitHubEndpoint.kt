package com.uap.demo.endpoint

import com.uap.demo.service.GitHubService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/demo/github")
class GitHubEndpoint {

    @Autowired
    lateinit var gitHubService : GitHubService

    @RequestMapping("/{userName}/languages")
    fun getLanguages(@PathVariable(name = "userName") userName:String): ResponseEntity<List<String>> =
        ResponseEntity.ok(gitHubService.getLanguages(userName))
}