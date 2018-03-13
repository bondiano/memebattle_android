package com.membattle.data.api.model.res.coins;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("game_id")
    @Expose
    private Integer gameId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("coins")
    @Expose
    private String coins;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

}