package com.example.cocktailexplorer;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("search.php")
    Call<CocktailData> searchCocktails(@Query("s") String query);
}
