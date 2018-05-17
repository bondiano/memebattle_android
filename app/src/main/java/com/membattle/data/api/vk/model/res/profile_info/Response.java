package com.membattle.data.api.vk.model.res.profile_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {
    public Response() {
    }
    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("home_town")
    @Expose
    private String home_town;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("bdate_visibility")
    @Expose
    private String bdate_visibility;
    @SerializedName("relation")
    @Expose
    private String relation;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("screen_name")
    @Expose
    private String screen_name;
    @SerializedName("bdate")
    @Expose
    private String bdate;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("country")
    @Expose
    private Country country;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHome_town() {
        return home_town;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBdate_visibility() {
        return bdate_visibility;
    }

    public void setBdate_visibility(String bdate_visibility) {
        this.bdate_visibility = bdate_visibility;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ClassPojo [first_name = " + first_name + ", phone = " + phone + ", sex = " + sex + ", home_town = " + home_town + ", status = " + status + ", bdate_visibility = " + bdate_visibility + ", relation = " + relation + ", last_name = " + last_name + ", screen_name = " + screen_name + ", bdate = " + bdate + ", city = " + city + ", country = " + country + "]";
    }
}
