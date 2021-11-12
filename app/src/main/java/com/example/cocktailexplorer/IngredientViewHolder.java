package com.example.cocktailexplorer;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IngredientViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    ImageButton imageButton;

    public IngredientViewHolder(@NonNull View itemView, boolean showRemove) {
        super(itemView);
        textView=itemView.findViewById(R.id.tv_ingredient);
        imageButton=itemView.findViewById(R.id.remove_ingredient);

        imageButton.setVisibility(showRemove ? View.VISIBLE : View.INVISIBLE);
    }

    public void setIngredient(String ingredient, View.OnClickListener onRemove){
        textView.setText(ingredient);
        imageButton.setOnClickListener(onRemove);
    }
}
