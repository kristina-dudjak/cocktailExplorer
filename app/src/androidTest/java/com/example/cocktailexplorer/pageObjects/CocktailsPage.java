package com.example.cocktailexplorer.pageObjects;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.example.cocktailexplorer.R;

public class CocktailsPage {

    public void searchCocktails(String query) throws InterruptedException {
        onView(withId(R.id.edText)).perform(typeText(query));
        onView(withId(R.id.btn_search)).perform(click());
        closeSoftKeyboard();
    }

    public boolean hasCocktail(String name){
        try {
            onView(withId(R.id.recycler_cocktails)).perform(RecyclerViewActions.scrollTo(
                    hasDescendant(withText(name))
            ));
            return true;
        }
        catch (PerformException exception){
            return false;
        }
    }

    public CocktailDetailsPage getDetails(int position){
        onView(withId(R.id.recycler_cocktails)).perform(
                RecyclerViewActions.actionOnItemAtPosition(position, click())
        );
        return new CocktailDetailsPage();
    }
}
