package com.membattle.data.api.meme.model.res.game.PairMem;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("game_id")
    @Expose
    private Integer gameId;
    @SerializedName("leftMemeId")
    @Expose
    private String leftMemeId;
    @SerializedName("leftMemeImg")
    @Expose
    private String leftMemeImg;
    @SerializedName("rightMemeId")
    @Expose
    private String rightMemeId;
    @SerializedName("rightMemeImg")
    @Expose
    private String rightMemeImg;
    @SerializedName("rightLikes")
    @Expose
    private String rightLikes;
    @SerializedName("leftLikes")
    @Expose
    private String leftLikes;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getLeftMemeId() {
        return leftMemeId;
    }

    public void setLeftMemeId(String leftMemeId) {
        this.leftMemeId = leftMemeId;
    }

    public String getLeftMemeImg() {
        return leftMemeImg;
    }

    public void setLeftMemeImg(String leftMemeImg) {
        this.leftMemeImg = leftMemeImg;
    }

    public String getRightMemeId() {
        return rightMemeId;
    }

    public void setRightMemeId(String rightMemeId) {
        this.rightMemeId = rightMemeId;
    }

    public String getRightMemeImg() {
        return rightMemeImg;
    }

    public void setRightMemeImg(String rightMemeImg) {
        this.rightMemeImg = rightMemeImg;
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

}