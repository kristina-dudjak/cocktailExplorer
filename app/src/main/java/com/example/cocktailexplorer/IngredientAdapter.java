package com.example.cocktailexplorer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

    private List<String> ingredients=new ArrayList<>();
    private boolean showRemove;

    public IngredientAdapter(boolean showRemove){
        this.showRemove=showRemove;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ingredientView= LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient,parent,false);
        return new IngredientViewHolder(ingredientView,showRemove);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        String ingredient=ingredients.get(position);
        holder.setIngredient(ingredient, v -> removeIngredient(ingredient));
    }

    public void setData(List<String> ingredients){
        this.ingredients.clear();
        this.ingredients.addAll(ingredients);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public void addIngredient(String ingredient){
        ingredients.add(ingredient);
        notifyItemInserted(ingredients.size()-1);
    }

    public void  removeIngredient(String ingredient){
        int i=ingredients.indexOf(ingredient);
        ingredients.remove(i);
        notifyItemRemoved(i);
    }
}
