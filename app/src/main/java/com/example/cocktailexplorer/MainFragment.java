package com.example.cocktailexplorer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class MainFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ScreenSlidePagerAdapter screenSlidePagerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager=view.findViewById(R.id.view_pager);
        tabLayout=view.findViewById(R.id.tab_layout);
        setUpPager();
    }

    private void setUpPager() {
        screenSlidePagerAdapter=new ScreenSlidePagerAdapter(requireFragmentManager());
        viewPager.setAdapter(screenSlidePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setFavCocktail(Cocktail cocktail){
        screenSlidePagerAdapter.setCocktail(cocktail);
    }

    public void setIngredient(String ingredient){
        screenSlidePagerAdapter.setIngredient(ingredient);
        }


}