package com.assembly.model

import com.google.gson.annotations.SerializedName

class UserRoot {
    @SerializedName("items")
    List<User> items = new ArrayList<>()

}

class User {
    @SerializedName("user_id")
    Integer id

    @SerializedName("reputation")
    Integer reputation

    @SerializedName("badge_counts")
    BadgeCounts badgeCounts
}

class BadgeCounts {
    @SerializedName("bronze")
    Integer bronze

    @SerializedName("silver")
    Integer silver

    @SerializedName("gold")
    Integer gold
}