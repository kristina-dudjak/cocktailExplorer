package com.example.cocktailexplorer.pageObjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.contrib.RecyclerViewActions;

import com.example.cocktailexplorer.R;

public class CocktailDetailsPage {

    public boolean hasCocktailName(String name){
        try {
            onView(withId(R.id.detail_name)).check(matches(withText("Cocktail:" + name)));
            return true;
        }
        catch (AssertionError error){
            return false;
        }
    }

    public void addToFavourites(){
        onView(withId(R.id.heart)).perform(click());
    }

    public void addToShoppingList(){
        onView(withId(R.id.cart)).perform(click());
    }
}
