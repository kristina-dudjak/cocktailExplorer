package com.example.cocktailexplorer.pageObjects;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.example.cocktailexplorer.R;
import com.example.cocktailexplorer.Util;

import org.junit.Test;

public class FavouritesPage {
    private final String query = "Martini";

    public boolean hasCocktail(String name){
        try {
            onView(withId(R.id.recycler_favourites)).perform(RecyclerViewActions.scrollTo(
                    hasDescendant(withText(name))
            ));
            return true;
        }
        catch (PerformException exception){
            return false;
        }
    }

    public void removeFavourite(int position){
        onView(withId(R.id.recycler_favourites)).perform(RecyclerViewActions.actionOnItemAtPosition(position,
                Util.clickChildViewWithId(R.id.remove_favourite)));
    }

}
