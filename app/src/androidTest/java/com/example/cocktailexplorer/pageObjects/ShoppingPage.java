package com.example.cocktailexplorer.pageObjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.example.cocktailexplorer.R;
import com.example.cocktailexplorer.Util;

import java.util.List;

public class ShoppingPage {

    public boolean hasIngredient(String ingredient){
        try {
            onView(withId(R.id.recycler_shopping_list)).perform(RecyclerViewActions.scrollTo(
                    hasDescendant(withText(ingredient))
            ));
            return true;
        }
        catch (PerformException exception){
            return false;
        }
    }

    public boolean hasIngredients(List<String> ingredients){
        try {
            ViewInteraction interaction = onView(withId(R.id.recycler_shopping_list));
            for (String ingredient : ingredients){
                interaction.perform(RecyclerViewActions.scrollTo(hasDescendant(withText(ingredient))));
            }
            return true;
        }
        catch (PerformException exception){
            return false;
        }
    }

    public void removeIngredient(int position){
        onView(withId(R.id.recycler_shopping_list)).perform(RecyclerViewActions.actionOnItemAtPosition(position,
                Util.clickChildViewWithId(R.id.remove_ingredient)));
    }
}
