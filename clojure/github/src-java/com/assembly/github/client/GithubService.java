package com.assembly.github.client;

import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class GithubService {

    private GitHubClient gitHubClient;

    public GithubService() {
        var retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.gitHubClient = retrofit.create(GitHubClient.class);
    }

    public User getUserInfo(String username) {
        try {
            return this.gitHubClient.getUser(username).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
