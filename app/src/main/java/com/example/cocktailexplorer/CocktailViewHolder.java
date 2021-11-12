package com.example.cocktailexplorer;

import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CocktailViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textView;
    private ImageButton imageButton;

    public CocktailViewHolder(@NonNull View itemView, boolean showRemove) {
        super(itemView);
        this.imageView=itemView.findViewById(R.id.img_cocktail);
        textView=itemView.findViewById(R.id.tv_cocktailName);
        imageButton=itemView.findViewById(R.id.remove_favourite);

        imageButton.setVisibility(showRemove ? View.VISIBLE : View.INVISIBLE);
    }

    public void setCocktail(Cocktail cocktail, CocktailClickListener clickListener, View.OnClickListener onRemove){
        itemView.setOnClickListener(v -> clickListener.onClick(cocktail));
        imageButton.setOnClickListener(onRemove);
        textView.setText(cocktail.getName());
        Picasso.get().load(cocktail.getImageURL()).into(imageView);
    }
}
