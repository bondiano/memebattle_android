package com.membattle.data.api.vk.model.res.profile_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.membattle.data.api.vk.model.res.profile_info.error.Error;

public class ProfileInfo {
    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("error")
    @Expose
    private Error error;

    public Error getError ()
    {
        return error;
    }

    public void setError (Error error)
    {
        this.error = error;
    }

    public ProfileInfo() {
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ClassPojo [response = " + response + "]";
    }
}
