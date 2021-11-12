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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CocktailDetailsFragment extends Fragment {

    private Cocktail cocktail;
    private ImageButton heart;
    private ImageButton cart;
    private ImageView detail_image;
    private TextView name;
    private TextView category;
    private TextView glass;
    private TextView instructions;
    private RecyclerView recyclerView;
    private IngredientAdapter ingredientAdapter;

    List<String> list=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cocktail_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        heart=view.findViewById(R.id.heart);
        heart.setOnClickListener(v -> {
            setFavouriteCocktail(cocktail);
            Toast.makeText(view.getContext(),getResources().getString(R.string.toast_added_favourite),Toast.LENGTH_SHORT).show();
        });


        cart=view.findViewById(R.id.cart);
        cart.setOnClickListener(v -> {
            addToShoppingList();
            Toast.makeText(view.getContext(),getResources().getString(R.string.toast_add_to_shopping),Toast.LENGTH_SHORT).show();

        });
        detail_image =view.findViewById(R.id.detail_image);
        name=view.findViewById(R.id.detail_name);
        category=view.findViewById(R.id.detail_category);
        glass=view.findViewById(R.id.detail_glass);
        instructions=view.findViewById(R.id.detail_instructions);
        recyclerView =view.findViewById(R.id.list_ingredients);
        ingredientAdapter=new IngredientAdapter(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(ingredientAdapter);
        setCocktail(cocktail);
    }

    private void setFavouriteCocktail(Cocktail cocktail){
        MainActivity mainActivity=(MainActivity) requireActivity();
        mainActivity.setFavouriteCocktail(cocktail);
    }

    private void addToShoppingList(){
        MainActivity mainActivity=(MainActivity) requireActivity();
        for (int i=0;i<list.size();i++)
        {
            mainActivity.addToList(list.get(i));
        }

    }

    public void setCocktail(Cocktail cocktail){
        this.cocktail=cocktail;
        if(detail_image!=null) {
            Picasso.get().load(cocktail.getImageURL()).into(detail_image);
            name.setText(getResources().getString(R.string.cocktail)+cocktail.getName());
            category.setText(getResources().getString(R.string.category)+cocktail.getStrCategory());
            glass.setText(getResources().getString(R.string.glass)+cocktail.getStrGlass());
            instructions.setText(getResources().getString(R.string.instructions)+cocktail.getInstructions());
            ingredientAdapter.setData(getIngredients(cocktail));
        }
    }

    private List<String> getIngredients(Cocktail cocktail){
        if(cocktail.getStrIngredient1()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient1());
        if(cocktail.getStrIngredient2()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient2());
        if(cocktail.getStrIngredient3()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient3());
        if(cocktail.getStrIngredient4()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient4());
        if(cocktail.getStrIngredient5()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient5());
        if(cocktail.getStrIngredient6()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient6());
        if(cocktail.getStrIngredient7()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient7());
        if(cocktail.getStrIngredient8()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient8());
        if(cocktail.getStrIngredient9()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient9());
        if(cocktail.getStrIngredient10()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient10());
        if(cocktail.getStrIngredient11()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient11());
        if(cocktail.getStrIngredient12()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient12());
        if(cocktail.getStrIngredient13()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient13());
        if(cocktail.getStrIngredient14()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient14());
        if(cocktail.getStrIngredient15()==null){
            return list;
        }
        list.add(cocktail.getStrIngredient15());
        return list;
    }

}