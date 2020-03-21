package com.example.cook;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//overview

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button context_menu_btn = findViewById(R.id.recipe_options_01);
        registerForContextMenu(context_menu_btn);

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

    @Override
    public  void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("options");
        menu.add(0, v.getId(), 0, "rename");
        menu.add(0, v.getId(), 0, "edit");
        menu.add(0, v.getId(), 0, "delete");
    }


//TODO: write function for contextmenu buttons( rename , edit , delete)
   /* @Override
    public boolean onContextItemSelected(MenuItem item) {

    }*/

    //switch tabs


    //search_bar

    //delete recipe



}
