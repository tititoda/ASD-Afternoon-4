package com.example.cook;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.SearchEvent;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class OverviewListAdapter extends ArrayAdapter<String> {
    private String[] recipeName;
    private String[] cookingTime;
    private String[] preparationTime;
    private String[] recipeType;
    private Integer[] recipeImageID;
    private Activity context;

    public OverviewListAdapter(Activity context, String[] recipeName, String[] cookingTime,
                               String[] preparationTime, String[] recipeType,
                               Integer[] recipeImageID){
        super(context, R.layout.recipe_item, recipeName);
        this.context = context;
        this.recipeName = recipeName;
        this.cookingTime = cookingTime;
        this.preparationTime = preparationTime;
        this.recipeType = recipeType;
        this.recipeImageID = recipeImageID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
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
        viewHolder.imageViewRecipeOverview.setImageResource(recipeImageID[position]);
        viewHolder.textViewRecipeName.setText(recipeName[position]);
        viewHolder.textViewCookingTime.setText(cookingTime[position]);
        viewHolder.textViewPreparationTime.setText(preparationTime[position]);
        viewHolder.textViewRecipeType.setText(recipeType[position]);

        return viewObject;

    }

    class ViewHolder{
        TextView textViewRecipeName;
        TextView textViewCookingTime;
        TextView textViewPreparationTime;
        TextView textViewRecipeType;
        ImageView imageViewRecipeOverview;
        ViewHolder (View v)
        {
            textViewRecipeName = (TextView) v.findViewById(R.id.textViewRecipeName);
            textViewCookingTime = (TextView) v.findViewById(R.id.textViewCookingTime);
            textViewPreparationTime = (TextView) v.findViewById(R.id.textViewPreparationTime);
            textViewRecipeType = (TextView) v.findViewById(R.id.textViewRecipeType);
            imageViewRecipeOverview = (ImageView) v.findViewById(R.id.imageViewRecipeOverview);
        }
    }

}
