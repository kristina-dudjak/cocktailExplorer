package com.example.cocktailexplorer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CocktailData {
    @SerializedName("drinks")
    public List<Cocktail> cocktails;

}
