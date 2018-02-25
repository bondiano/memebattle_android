package com.mrswimmer.membattle.data.api.res.rate;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Rate {

    @SerializedName("userRating")
    @Expose
    private UserRating userRating;
    @SerializedName("globalRating")
    @Expose
    private List<GlobalRating> globalRating = null;

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public List<GlobalRating> getGlobalRating() {
        return globalRating;
    }

    public void setGlobalRating(List<GlobalRating> globalRating) {
        this.globalRating = globalRating;
    }

}