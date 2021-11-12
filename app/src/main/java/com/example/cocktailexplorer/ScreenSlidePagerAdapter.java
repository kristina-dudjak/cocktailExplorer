package com.example.cocktailexplorer;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Arrays;
import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final String[] TAB_NAMES = {"COCKTAILS","FAVOURITES","SHOPPING"};
    FavouritesFragment favouriteFragment;
    ShoppingListFragment shoppingListFragment;

    public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        favouriteFragment=new FavouritesFragment();
        shoppingListFragment=new ShoppingListFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CocktailsFragment();
            case 1:
                return favouriteFragment;
            default:
                return shoppingListFragment;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_NAMES[position];
    }

    @Override
    public int getCount() {
        return TAB_NAMES.length;
    }

    public void setCocktail(Cocktail cocktail){
        favouriteFragment.setFavourite(cocktail);
    }

    public void setIngredient(String ingredient) {
        shoppingListFragment.setIngredient(ingredient);
    }
}
