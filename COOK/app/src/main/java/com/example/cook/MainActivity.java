package com.example.cook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toolbar;


import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

//overview
public class MainActivity extends AppCompatActivity {
    private ArrayList<Recipe> currentlySelectedRecipe = new ArrayList<>();
    private Boolean isAll = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner_filter_tags);

         /*
        TabLayout
        */
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabMode);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 1){
                    //reset spinner
                    spinner.setSelection(0);

                    loadListView(Recipe.favoriteRecipe);
                    isAll = false;
                }
                else
                {
                    //reset spinner
                    spinner.setSelection(0);

                    loadListView(Recipe.allRecipe);
                    isAll = true;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                if(tab.getPosition() == 1)
                {
                    //reset spinner
                    spinner.setSelection(0);

                    loadListView(Recipe.favoriteRecipe);
                    isAll = false;
                }
                else
                {
                    //reset spinner
                    spinner.setSelection(0);

                    loadListView(Recipe.allRecipe);
                    isAll = true;
                }
            }
        });

        /*
        ListView
        */
        ListView recipe_overview = findViewById((R.id.listViewShowRecipes));
        registerForContextMenu(recipe_overview);


        ///////////spinner filter tags///////////////////////

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tags_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(isAll)
                    loadListView(FilterTags.getFilteredRecipe(position,Recipe.allRecipe));
                else
                    loadListView(FilterTags.getFilteredRecipe(position,Recipe.favoriteRecipe));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        if(Recipe.initialised == false)
        {
            try {
            /*
            get data from xml
            */
                XMLFileParser parse = new XMLFileParser();
                parse.parseXMLFile(this);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Recipe.initialised = true;
        }

        else if(Recipe.new_recipe_added == true) {
            addRecipe();
            Recipe.new_recipe_added = false;
        }

        else if(Recipe.edit_recipe == true) {
            Recipe.allRecipe.set(Recipe.recipe_to_edit_index, Recipe.recipe_to_edit);
            Recipe.edit_recipe = false;
        }
    }

    public void startAddRecipe (View v) {
        Recipe.edit_recipe = false;
        onPause();

        Intent add_recipe_intent = new Intent(MainActivity.this, AddRecipe.class);
        startActivity(add_recipe_intent);

        finish();
    }

    //context menu items
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        ListView recipe_overview = (ListView) v;

        menu.setHeaderTitle("options");
        menu.add(0, v.getId(), 0, "rename");
        menu.add(0, v.getId(), 0, "edit");
        menu.add(0, v.getId(), 0, "delete");
    }

    //context menu item selection (long click)
    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        final AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int recipe_index = (int) menuInfo.id;
        final Recipe tmp_recipe = currentlySelectedRecipe.get(recipe_index);

        if (item.getTitle() == "rename") {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("rename recipe: "+tmp_recipe.getName());

            final EditText input = new EditText(this);
            builder.setView(input);

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tmp_recipe.setName(input.getText().toString());
                    loadListView(currentlySelectedRecipe);
                }
            });
            builder.show();
        }
        if (item.getTitle() == "delete") {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("do you want to delete: "+ tmp_recipe.getName()+"?");

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    currentlySelectedRecipe.remove(recipe_index);
                    loadListView(currentlySelectedRecipe);
                }
            });
            builder.show();
        }
        if (item.getTitle() == "edit") {
            Recipe.recipe_to_edit = currentlySelectedRecipe.get(recipe_index);
            Recipe.edit_recipe = true;
            Recipe.recipe_to_edit_index = recipe_index;

            Intent add_recipe_intent = new Intent(MainActivity.this, AddRecipe.class);
            startActivity(add_recipe_intent);
            finish();
        }
        return true;
    }

    //fills the list View
    private void loadListView(ArrayList<Recipe> recipesToLoad){
        currentlySelectedRecipe = recipesToLoad;
        int size = recipesToLoad.size();
        String[] loadRecipeName = new String[size];
        String[] loadCookingTime = new String[size];
        String[] loadPreparationTime = new String[size];
        String[] loadRecipeType = new String[size];
        Integer[] loadImageID = new Integer[size];
        Boolean[] isFavorite = new Boolean[size];

        for(int iterator = 0; iterator < size; iterator++)
        {
            Recipe tempRecipe = recipesToLoad.get(iterator);
            loadRecipeName[iterator] = tempRecipe.getName();
            loadCookingTime[iterator] = Integer.toString(tempRecipe.getCooking_time());
            loadPreparationTime[iterator] = Integer.toString(tempRecipe.getPrep_time());
            loadRecipeType[iterator] = tempRecipe.getStringTagForListView();
            loadImageID[iterator] = tempRecipe.getFood_picture();
            if(Recipe.favoriteRecipe.contains(tempRecipe))
                isFavorite[iterator] = true;
            else
                isFavorite[iterator] = false;
        }

        ListView listViewRecipeOverview = findViewById(R.id.listViewShowRecipes);
        OverviewListAdapter customListView = new OverviewListAdapter(this, loadRecipeName,
                loadCookingTime, loadPreparationTime, loadRecipeType, loadImageID, isFavorite);
        listViewRecipeOverview.setAdapter(customListView);
    }

    public void sortByTime(View view)
    {
        loadListView(FilterTags.getTimeSortedRecipes(currentlySelectedRecipe));
    }

    private void addRecipe() {
        String name = AddRecipe.name;
        String description = AddRecipe.description;
        int prep_time = AddRecipe.prep_time;
        int cooking_time = AddRecipe.cooking_time;
        String sbs_description = AddRecipe.sbs_description;
        int food_picture = this.getResources().getIdentifier("tarator" ,
                "drawable", getPackageName());
        Boolean[] tags = AddRecipe.tags;

        Recipe.allRecipe.add(new Recipe(100, name, description, prep_time, cooking_time, food_picture, sbs_description, tags));
    }
}
