package com.example.cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;

//overview
public class MainActivity extends AppCompatActivity {
    ArrayList<Recipe> recipes = new ArrayList<Recipe>(){};
    //ArrayList<String> recipeName = new ArrayList<String>();
    //ArrayList<String> cookingTime = new ArrayList<String>();
    //ArrayList<String> preparationTime = new ArrayList<String>();
    //ArrayList<String> recipeType = new ArrayList<String>();
    //ArrayList<Integer> imageID = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            XMLFileParser parse = new XMLFileParser();
            recipes = parse.parseXMLFile(this);
            loadListView();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public void startAddRecipe (View v) {
        Intent add_recipe_intent = new Intent(MainActivity.this, AddRecipe.class);
        startActivity(add_recipe_intent);
    }

    private void loadListView(){
        int size = recipes.size();
        String[] loadRecipeName = new String[size];
        String[] loadCookingTime = new String[size];
        String[] loadPreparationTime = new String[size];
        String[] loadRecipeType = new String[size];
        Integer[] loadImageID = new Integer[size];


        for(int iterator = 0; iterator < size; iterator++)
        {
            Recipe tempRecipe = recipes.get(iterator);
            loadRecipeName[iterator] = tempRecipe.getName();
            loadCookingTime[iterator] = Integer.toString(tempRecipe.getCooking_time());
            loadPreparationTime[iterator] = Integer.toString(tempRecipe.getPrep_time());
            loadRecipeType[iterator] = "meat";
            loadImageID[iterator] = R.drawable.apple;

        }

        ListView listViewRecipeOverview = findViewById(R.id.lsitViewShowRecipes);
        OverviewListAdapter customListView = new OverviewListAdapter(this, loadRecipeName,
                loadCookingTime, loadPreparationTime, loadRecipeType, loadImageID);
        listViewRecipeOverview.setAdapter(customListView);
    }
}
