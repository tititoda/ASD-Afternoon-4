package com.example.cook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.tabs.TabLayout;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//overview
public class MainActivity extends AppCompatActivity {

    class SearchResult {
        Recipe found;
        int matches;
        SearchResult(Recipe found, int matches) {
            this.found = found;
            this.matches = matches;
        }
    }
    class SearchResultMatchesComparator implements Comparator<SearchResult> {
        public int compare(SearchResult s1, SearchResult s2) {
            if (s1.matches < s2.matches)
                return 1;
            else if (s1.matches > s2.matches)
                return -1;
            return 0;
        }
    }

    ArrayList<Recipe> recipes = new ArrayList<Recipe>(){};
    ArrayList<Recipe> foundRecipes = new ArrayList<Recipe>(){};
    PriorityQueue<SearchResult> searchResults = new PriorityQueue<SearchResult>(1,
            new SearchResultMatchesComparator());
    private ArrayList<Recipe> currentlySelectedRecipe = new ArrayList<>();
    private Boolean isAll = true;

    private SearchView ourSearchBar;
    private TextView debugText7;

    private String[] splitSearchQuery(String query) {
        return query.split("[-, ]+");
    }
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
        //debugText7 = findViewById(R.id.debugText7);
        //debugText7.setText("aasdf");
        ourSearchBar = findViewById(R.id.search_bar);
        ourSearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (isAll) {
                    recipes = Recipe.allRecipe;
                }
                else {
                    recipes = Recipe.favoriteRecipe;
                }
                boolean foundSomething = false;
                String[] splitQuery = null;
                foundRecipes.clear();
                //search description text for query
                //results will be displayed at top
                for (Recipe r : recipes) {
                    if (r.getName().toLowerCase().contains(query.toLowerCase())) {
                        //debugText7.setText("found " + r.getName());
                        foundRecipes.add(r);
                        foundSomething = true;
                    }
                }
                //search description for query, order by hits of search terms
                splitQuery = splitSearchQuery(query);
                searchResults = new PriorityQueue<SearchResult>(1, new SearchResultMatchesComparator());
                for (Recipe r : recipes) {
                    int matches = 0;
                    for (String word : splitQuery) {
                        if (r.getDescription().toLowerCase().contains(word.toLowerCase())) {
                            matches++;
                        }
                        else {
                            for (GuideStep step : r.getSBSDescription()) {
                                if (step.getDescription().toLowerCase().contains(word.toLowerCase())) {
                                    matches++;
                                    break;
                                }
                            }
                        }
                    }
                    if (matches > 0) {
                        searchResults.add(new SearchResult(r, matches));
                        foundSomething = true;
                    }
                }
                while(!searchResults.isEmpty()) {
                    SearchResult s = searchResults.poll();
                    if (!foundRecipes.contains(s.found)) {
                        foundRecipes.add(s.found);
                    }
                    //debugText7.setText("found " + s.found.getName() + " " + s.matches + "matches");
                }

                if (!foundSomething) {
                    //debugText7.setText("failed to find " + query);
                    if (isAll) {
                        loadListView(Recipe.allRecipe);
                    }
                    else {
                        loadListView(Recipe.favoriteRecipe);
                    }
                }
                else {
                    loadListView(foundRecipes);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
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
    private void loadListView(ArrayList<Recipe> recipesToDisplay) {
        currentlySelectedRecipe = recipesToDisplay;
        int size = recipesToDisplay.size();
        String[] loadRecipeName = new String[size];
        String[] loadCookingTime = new String[size];
        String[] loadPreparationTime = new String[size];
        String[] loadRecipeType = new String[size];
        Integer[] loadImageID = new Integer[size];
        Boolean[] isFavorite = new Boolean[size];

        for(int iterator = 0; iterator < size; iterator++)
        {
            Recipe tempRecipe = recipesToDisplay.get(iterator);
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
        ArrayList<GuideStep> sbs_description = AddRecipe.sbs_description;
        int food_picture = this.getResources().getIdentifier("tarator" ,
                "drawable", getPackageName());
        Boolean[] tags = AddRecipe.tags;

        Recipe.allRecipe.add(new Recipe(100, name, description, prep_time, cooking_time, food_picture, sbs_description, tags));
    }
}
