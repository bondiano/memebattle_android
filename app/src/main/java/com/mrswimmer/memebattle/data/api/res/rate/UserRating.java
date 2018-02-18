package com.mrswimmer.memebattle.data.api.res.rate;




import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRating {

    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("coins")
    @Expose
    private int coins;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

}