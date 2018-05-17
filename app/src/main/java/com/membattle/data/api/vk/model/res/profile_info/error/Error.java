package com.membattle.data.api.vk.model.res.profile_info.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error
{
    @SerializedName("error_code")
    @Expose
    private String error_code;
    @SerializedName("error_msg")
    @Expose
    private String error_msg;

    public String getError_code ()
    {
        return error_code;
    }

    public void setError_code (String error_code)
    {
        this.error_code = error_code;
    }

    public String getError_msg ()
    {
        return error_msg;
    }

    public void setError_msg (String error_msg)
    {
        this.error_msg = error_msg;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [error_code = "+error_code+", error_msg = "+error_msg;
    }
}
