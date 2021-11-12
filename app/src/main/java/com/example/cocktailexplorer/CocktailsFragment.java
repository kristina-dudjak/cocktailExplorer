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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CocktailsFragment extends Fragment {

    private EditText editText;
    private Button button;
    private RecyclerView recyclerView;
    private CocktailAdapter recyclerAdapter;
    private Call<CocktailData> apiCall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cocktails, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.edText);
        button = view.findViewById(R.id.btn_search);
        button.setOnClickListener(v -> setUpApiCall(editText.getText().toString()));

        recyclerView = view.findViewById(R.id.recycler_cocktails);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAdapter = new CocktailAdapter(false, new CocktailClickListener() {
            @Override
            public void onClick(Cocktail cocktail) {
                showCocktailDetails(cocktail);
            }
        });
        recyclerView.setAdapter(recyclerAdapter);
    }


    private void setUpApiCall(String query) {
        apiCall = NetworkUtils.getApiInterface().searchCocktails(query);
        apiCall.enqueue(new Callback<CocktailData>() {
            @Override
            public void onResponse(Call<CocktailData> call, Response<CocktailData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    showCocktails(response.body().cocktails != null ? response.body().cocktails : new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<CocktailData> call, Throwable t) {
                Toast.makeText(CocktailsFragment.this.getContext(), "Error", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    private void showCocktails(List<Cocktail> cocktails) {
        recyclerAdapter.setData(cocktails);
    }

    private void showCocktailDetails(Cocktail cocktail) {
        MainActivity mainActivity = (MainActivity) requireActivity();
        CocktailDetailsFragment cocktailDetailsFragment = new CocktailDetailsFragment();
        cocktailDetailsFragment.setCocktail(cocktail);
        mainActivity.showFragment(cocktailDetailsFragment);
    }

}
