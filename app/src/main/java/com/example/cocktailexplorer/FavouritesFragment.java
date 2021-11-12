package com.example.cocktailexplorer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class FavouritesFragment extends Fragment {

    private RecyclerView recyclerView;
    private CocktailAdapter cocktailAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourites, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler_favourites);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cocktailAdapter=new CocktailAdapter(true, new CocktailClickListener() {
            @Override
            public void onClick(Cocktail cocktail) {
            }
        });
        recyclerView.setAdapter(cocktailAdapter);

    }

    public  void setFavourite(Cocktail cocktail){
        if(!cocktailAdapter.containsCocktail(cocktail))
        cocktailAdapter.addCocktail(cocktail);
    }
}