package com.example.cook;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailView extends AppCompatActivity {


   static Recipe detail_view_recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);

        ImageView detail_view_img = findViewById(R.id.imageViewDetailView);
        TextView detail_view_name = findViewById(R.id.detailViewRecipeName);
        TextView detail_view_description = findViewById(R.id.detailViewRecipeDescription);
        TextView detail_view_recipe_type = findViewById(R.id.detailViewRecipeType);
        TextView detail_view_cooking_time = findViewById(R.id.detailViewCookingTime);
        TextView detail_view_prep_time = findViewById(R.id.detailViewPreparationTime);
        TextView detail_view_sbs = findViewById(R.id.detailViewSbs);


        detail_view_img.setImageResource(detail_view_recipe.getFood_picture());
        detail_view_name.setText(detail_view_recipe.getName());
        detail_view_description.setText(detail_view_recipe.getDescription());
        detail_view_recipe_type.setText(detail_view_recipe.getStringTagForListView());
        detail_view_cooking_time.setText(Integer.toString(detail_view_recipe.getCooking_time()));
        detail_view_prep_time.setText(Integer.toString(detail_view_recipe.getPrep_time()));
        String detail_sbs_string = new String();
        for(GuideStep step: detail_view_recipe.getSBSDescription()){
            detail_sbs_string += step.getDescription();
        }
        detail_view_sbs.setText(detail_sbs_string);
    }
}
