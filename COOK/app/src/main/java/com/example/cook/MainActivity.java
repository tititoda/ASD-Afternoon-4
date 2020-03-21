package com.example.cook;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

//overview

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //fill recipes
    //loop through constrainLayouts
        // load : title, picture

    //add recipe
        //goto activity add_recipe
    public void startAddRecipe (View v) {
        Intent add_recipe_intent = new Intent(MainActivity.this, add_recipe.class);
        startActivity(add_recipe_intent);
    }


    //menu

    //switch tabs


    //search_bar

    //delete recipe



}
