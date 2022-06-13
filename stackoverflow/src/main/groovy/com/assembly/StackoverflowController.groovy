package com.assembly

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/stackoverflow")
class StackoverflowController {

    @Get(uri="/", produces="text/plain")
    String index() {
        "Example Response"
    }
}