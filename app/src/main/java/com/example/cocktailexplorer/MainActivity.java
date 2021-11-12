package com.example.cocktailexplorer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment;
    private Fragment currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.holder, mainFragment, "bs").commit();
        currentFragment=mainFragment;
    }

    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .hide(currentFragment).add(R.id.holder, fragment, "bs")
                .addToBackStack("bs")
                .commit();
        currentFragment=fragment;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        currentFragment = mainFragment;
    }

    public void setFavouriteCocktail(Cocktail cocktail){
        mainFragment.setFavCocktail(cocktail);
    }

    public void addToList(String ingredient){
        mainFragment.setIngredient(ingredient);
    }





}