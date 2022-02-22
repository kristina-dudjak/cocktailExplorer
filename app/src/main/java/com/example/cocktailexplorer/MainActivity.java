package com.example.cocktailexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
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