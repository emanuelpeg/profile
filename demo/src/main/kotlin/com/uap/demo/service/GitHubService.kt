package com.uap.demo.service

import com.uap.demo.client.GitHubClient
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface GitHubService {

    fun getLanguages(userName: String): List<String>

}

@Service
class GitHubServiceImpl : GitHubService {

    override fun getLanguages(userName: String): List<String> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gitHubClient = retrofit.create(GitHubClient::class.java)

        val repos = gitHubClient.listRepos(userName)?.execute()?.body()

        return if (repos == null) listOf()
        else repos?.map { it!!.language }?.distinct().filter { it != null }
    }

}