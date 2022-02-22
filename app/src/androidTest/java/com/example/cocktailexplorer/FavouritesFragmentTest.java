package com.example.cocktailexplorer;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cocktailexplorer.pageObjects.CocktailDetailsPage;
import com.example.cocktailexplorer.pageObjects.CocktailsPage;
import com.example.cocktailexplorer.pageObjects.FavouritesPage;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FavouritesFragmentTest extends BaseTest{

    private final String query = "Martini";

    @Test
    public void addToFavourites() throws InterruptedException {
        addFavourite();
        FavouritesPage favouritesPage = goToFavourites();
        assert favouritesPage.hasCocktail(query);
    }

    @Test
    public void removeFromFavourites() throws InterruptedException {
        addFavourite();
        FavouritesPage favouritesPage = goToFavourites();
        assert favouritesPage.hasCocktail(query);
        favouritesPage.removeFavourite(0);
        assert !favouritesPage.hasCocktail(query);
        Thread.sleep(1000);
    }

    private FavouritesPage goToFavourites() throws InterruptedException {
        pressBack();
        onView(withId(R.id.view_pager)).perform(swipeLeft());
        Thread.sleep(1000);
        return new FavouritesPage();
    }

    private void addFavourite() throws InterruptedException {
        CocktailsPage cocktailsPage = new CocktailsPage();
        cocktailsPage.searchCocktails(query);
        Thread.sleep(1000);
        CocktailDetailsPage cocktailDetailsPage = cocktailsPage.getDetails(0);
        cocktailDetailsPage.addToFavourites();
    }
}
