package com.membattle.data.api.model.res.game.PairLikes;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("game_id")
    @Expose
    private Integer gameId;
    @SerializedName("rightLikes")
    @Expose
    private String rightLikes;
    @SerializedName("leftLikes")
    @Expose
    private String leftLikes;
    @SerializedName("winner")
    @Expose
    private Integer winner;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getRightLikes() {
        return rightLikes;
    }

    public void setRightLikes(String rightLikes) {
        this.rightLikes = rightLikes;
    }

    public String getLeftLikes() {
        return leftLikes;
    }

    public void setLeftLikes(String leftLikes) {
        this.leftLikes = leftLikes;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

}