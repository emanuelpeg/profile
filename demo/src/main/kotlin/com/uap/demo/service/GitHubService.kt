package com.uap.demo.service

import com.uap.demo.client.GitHubClient
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.annotation.PostConstruct


interface GitHubService {

    fun getLanguages(userName: String): List<String>

    fun getSecundaryLanguages(userName: String): List<String>

    fun getAllLanguages(userName: String): List<String>

}

@Service
class GitHubServiceImpl : GitHubService {

    private val gitHubClient : GitHubClient;

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        gitHubClient = retrofit.create(GitHubClient::class.java)
    }

    override fun getLanguages(userName: String): List<String> {

        val repos = gitHubClient.listRepos(userName)?.execute()?.body()

        return if (repos == null) listOf()
        else repos?.map { it!!.language }?.distinct().filter { it != null }
    }

    override fun getSecundaryLanguages(userName: String): List<String> {

        val repos = gitHubClient.listRepos(userName)?.execute()?.body()

        return if (repos == null) listOf()
        else repos?.flatMap { gitHubClient.repoLenguages(userName, it!!.name)?.execute()?.body()?.keySet() ?: setOf() }?.distinct()
    }

    override fun getAllLanguages(userName: String): List<String> =
        this.getLanguages(userName).union(this.getSecundaryLanguages(userName)).distinct()

}