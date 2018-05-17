package com.membattle.data.api.meme.model.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("token_access")
    @Expose
    private String token_access;
    @SerializedName("token_refresh")
    @Expose
    private String token_refresh;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("coins")
    @Expose
    private String coins;
    @SerializedName("_id")
    @Expose
    private int _id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public int getId() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTokenAccess() {
        return token_access;
    }

    public void setToken_access(String token_access) {
        this.token_access = token_access;
    }

    public String getTokenRefresh() {
        return token_refresh;
    }

    public void setToken_refresh(String token_refresh) {
        this.token_refresh = token_refresh;
    }
}