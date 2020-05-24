package com.example.cook;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.SearchEvent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class OverviewListAdapter extends ArrayAdapter<String> {
    private String[] recipeName;
    private String[] cookingTime;
    private String[] preparationTime;
    private String[] recipeType;
    private Integer[] recipeImageID;
    private Boolean[] isFavorite;
    private Activity context;


    public OverviewListAdapter(Activity context, String[] recipeName, String[] cookingTime,
                               String[] preparationTime, String[] recipeType,
                               Integer[] recipeImageID, Boolean[] isFavorite){
        super(context, R.layout.recipe_item, recipeName);
        this.context = context;
        this.recipeName = recipeName;
        this.cookingTime = cookingTime;
        this.preparationTime = preparationTime;
        this.recipeType = recipeType;
        this.recipeImageID = recipeImageID;
        this.isFavorite = isFavorite;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View viewObject = convertView;
        ViewHolder viewHolder = null;

        if(viewObject==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            viewObject=layoutInflater.inflate(R.layout.recipe_item,null,true);
            viewHolder = new ViewHolder(viewObject);
            viewObject.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) viewObject.getTag();
        }
        //viewHolder.detailViewButton = convertView.findViewById(R.id.button_detail_view);
        //viewHolder.detailViewButton.setTag(position);
        viewHolder.detailViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailView.detail_view_recipe = Recipe.getRecipeByName(recipeName[position]);//????
                Intent detail_view_intent = new Intent(context, DetailView.class);
                context.startActivity(detail_view_intent);
            }
        });

        viewHolder.imageViewRecipeOverview.setImageResource(recipeImageID[position]);
        viewHolder.textViewRecipeName.setText(recipeName[position]);
        viewHolder.textViewCookingTime.setText(cookingTime[position]);
        viewHolder.textViewPreparationTime.setText(preparationTime[position]);
        viewHolder.textViewRecipeType.setText(recipeType[position]);
        viewHolder.switchFavorite.setText(recipeName[position]);
        if(isFavorite[position] == true) {

            viewHolder.switchFavorite.setChecked(true);
        }
        else{

            viewHolder.switchFavorite.setChecked(false);
        }
        /*
        Favourite Switch listener
        */
        viewHolder.switchFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //if event bugs
                if(!recipeName[position].equals(buttonView.getText()))
                    return;
                Recipe currentRecipe = Recipe.getRecipeByName(recipeName[position]);
                isFavorite[position] = isChecked;

                if(isChecked)
                {

                    Recipe.favoriteRecipe.add(currentRecipe);
                }
                else{
                    Recipe.favoriteRecipe.remove(currentRecipe);
                    }
            }
        });
        return viewObject;

    }



    class ViewHolder{
        TextView textViewRecipeName;
        TextView textViewCookingTime;
        TextView textViewPreparationTime;
        TextView textViewRecipeType;
        Switch switchFavorite;
        ImageView imageViewRecipeOverview;
        Button detailViewButton;
        ViewHolder (View v)
        {
            textViewRecipeName = (TextView) v.findViewById(R.id.textViewRecipeName);
            textViewCookingTime = (TextView) v.findViewById(R.id.textViewCookingTime);
            textViewPreparationTime = (TextView) v.findViewById(R.id.textViewPreparationTime);
            textViewRecipeType = (TextView) v.findViewById(R.id.textViewRecipeType);
            imageViewRecipeOverview = (ImageView) v.findViewById(R.id.imageViewRecipeOverview);
            switchFavorite = (Switch) v.findViewById(R.id.switch_favorite);
            detailViewButton = (Button) v.findViewById(R.id.button_detail_view);
        }
    }

}
