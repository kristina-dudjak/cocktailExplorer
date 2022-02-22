package com.example.cocktailexplorer;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cocktailexplorer.pageObjects.CocktailDetailsPage;
import com.example.cocktailexplorer.pageObjects.CocktailsPage;
import com.example.cocktailexplorer.pageObjects.ShoppingPage;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class ShoppingFragmentTest extends BaseTest{

    private String query = "Margarita";

    @Test
    public void addToShoppingList() throws InterruptedException {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Tequila");
        ingredients.add("Triple sec");
        ingredients.add("Lime juice");
        ingredients.add("Salt");
        addIngredients();
        ShoppingPage shoppingPage = goToShopping();
        assert shoppingPage.hasIngredients(ingredients);
    }

    @Test
    public void removeFromShoppingList() throws InterruptedException {
        addIngredients();
        ShoppingPage shoppingPage = goToShopping();
        assert shoppingPage.hasIngredient("Tequila");
        shoppingPage.removeIngredient(0);
        Thread.sleep(1000);
        assert !shoppingPage.hasIngredient("Tequila");
    }

    private ShoppingPage goToShopping() throws InterruptedException {
        pressBack();
        onView(withId(R.id.view_pager)).perform(swipeLeft()).perform(swipeLeft());
        Thread.sleep(1000);
        return new ShoppingPage();
    }

    private void addIngredients() throws InterruptedException {
        CocktailsPage cocktailsPage = new CocktailsPage();
        cocktailsPage.searchCocktails(query);
        Thread.sleep(1000);
        CocktailDetailsPage cocktailDetailsPage = cocktailsPage.getDetails(0);
        cocktailDetailsPage.addToShoppingList();
    }
}
