package com.uap.demo.service

import com.uap.demo.DemoApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DemoApplication::class])
class GitHubServiceTest {

    @Autowired
    lateinit var gitHubService:GitHubService

    @Test
    fun getlanguages() {
        val languages = gitHubService.getLanguages("emanuelpeg")
        assert(languages.isNotEmpty())
    }

}