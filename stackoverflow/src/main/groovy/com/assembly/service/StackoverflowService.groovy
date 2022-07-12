package com.assembly.service

import com.assembly.client.StackoverflowClient
import com.assembly.model.User
import io.micronaut.context.annotation.Bean
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface StackoverflowService {

    Optional<User> getUserInfo(Integer userid)

}

@Bean
class StackoverflowServiceImpl implements StackoverflowService {

    private StackoverflowClient stackoverflowClient;

    StackoverflowServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/2.3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        stackoverflowClient = retrofit.create(StackoverflowClient)
    }

    @Override
    Optional<User> getUserInfo(Integer userid) {
        var items = stackoverflowClient.user(userid).execute().body().items
        if (items.isEmpty()) {
            return Optional.empty()
        } else {
            return Optional.of(items.first())
        }
    }
}
