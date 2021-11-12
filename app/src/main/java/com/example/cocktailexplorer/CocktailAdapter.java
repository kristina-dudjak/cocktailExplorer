package com.example.cocktailexplorer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailViewHolder> {

    private List<Cocktail> dataList=new ArrayList<>();
    private CocktailClickListener clickListener;
    private boolean showRemove;

    public CocktailAdapter(boolean showRemove, CocktailClickListener clickListener){
        this.clickListener=clickListener;
        this.showRemove=showRemove;
    }

    @NonNull
    @Override
    public CocktailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cocktailView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cocktail,parent,false);
        return new CocktailViewHolder(cocktailView, showRemove);
    }

    @Override
    public void onBindViewHolder(@NonNull CocktailViewHolder holder, int position) {
        Cocktail cocktail = dataList.get(position);
        holder.setCocktail(cocktail,clickListener, v -> removeCocktail(cocktail));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setData(List<Cocktail> data){
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    public void addCocktail(Cocktail cocktail){
        dataList.add(cocktail);
        notifyItemInserted(dataList.size()-1);
    }

    public void removeCocktail(Cocktail cocktail){
        int i = dataList.indexOf(cocktail);
        dataList.remove(i);
        notifyItemRemoved(i);
    }

    public boolean containsCocktail(Cocktail cocktail){
        return dataList.contains(cocktail);
    }
}
