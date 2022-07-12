package com.assembly.controller

import com.assembly.model.User
import com.assembly.service.StackoverflowService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import jakarta.inject.Inject

@Controller("/stackoverflow")
class StackoverflowController {

    @Inject
    StackoverflowService stackoverflowService

    @Get(uri="/", produces="text/plain")
    String index() {
        "Example Response"
    }

    @Get(uri="/{userId}", produces="application/json")
    HttpResponse<User> getUserInfo(@PathVariable("userId") Integer userId) {
        Optional<User> user = stackoverflowService.getUserInfo(userId)
        if (user.isPresent()) {
            HttpResponse.ok(stackoverflowService.getUserInfo(userId).get())
        } else {
            HttpResponse.notFound()
        }
    }
}