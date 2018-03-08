package com.membattle.data.api.res.game.PairLikes;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PairLikes {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
