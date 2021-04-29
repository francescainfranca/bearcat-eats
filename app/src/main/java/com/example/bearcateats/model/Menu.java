
package com.example.bearcateats.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Menu {

    @SerializedName("popular")
    @Expose
    private List<Popular> popular = null;
    @SerializedName("recommended")
    @Expose
    private List<Recommended> recommended = null;

    public List<Popular> getPopular() {
        return popular;
    }

    public void setPopular(List<Popular> popular) {
        this.popular = popular;
    }

    public List<Recommended> getRecommended() {
        return recommended;
    }

    public void setRecommended(List<Recommended> recommended) {
        this.recommended = recommended;
    }

}
