package com.example.cocktailexplorer;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cocktailexplorer.pageObjects.CocktailDetailsPage;
import com.example.cocktailexplorer.pageObjects.CocktailsPage;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CocktailsFragmentTest extends BaseTest{

    private final String query = "Mojito";

    @Test
    public void findExactCocktail() throws InterruptedException {
        CocktailsPage cocktailsPage = getCocktails();
        assert cocktailsPage.hasCocktail(query);
    }

    @Test
    public void matchesCocktailName() throws InterruptedException {
        CocktailsPage cocktailsPage = getCocktails();
        CocktailDetailsPage detailsPage = cocktailsPage.getDetails(0);
        assert detailsPage.hasCocktailName(query);
    }

    private CocktailsPage getCocktails() throws InterruptedException {
        CocktailsPage cocktailsPage = new CocktailsPage();
        cocktailsPage.searchCocktails(query);
        Thread.sleep(1000);
        return cocktailsPage;
    }


}
