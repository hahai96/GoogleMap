package com.example.ha_hai.googlemap.Retrofit.image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageLocation {

    @SerializedName("response")
    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}