package com.example.cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

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

    private SearchView ourSearchBar;
    private TextView debugText7;

    private String[] splitSearchQuery(String query) {
        return query.split("[-, ]+");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            XMLFileParser parse = new XMLFileParser();
            recipes = parse.parseXMLFile(this);
            loadListView(recipes);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //debugText7 = findViewById(R.id.debugText7);
        //debugText7.setText("aasdf");
        ourSearchBar = findViewById(R.id.search_bar);
        ourSearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
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
                        if (r.getDescription().toLowerCase().contains(word.toLowerCase()) ||
                            r.getSBSDescription().toLowerCase().contains(word.toLowerCase())) {
                            matches++;
                        }
                    }
                    if (matches > 0) {
                        searchResults.add(new SearchResult(r, matches));
                        foundSomething = true;
                    }
                }
                while(!searchResults.isEmpty()) {
                    SearchResult s = searchResults.poll();
                    foundRecipes.add(s.found);
                    //debugText7.setText("found " + s.found.getName() + " " + s.matches + "matches");
                }

                if (!foundSomething) {
                    //debugText7.setText("failed to find " + query);
                    loadListView(recipes);
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
        Intent add_recipe_intent = new Intent(MainActivity.this, AddRecipe.class);
        startActivity(add_recipe_intent);
    }

    private void loadListView(ArrayList<Recipe> recipesToDisplay){
        int size = recipesToDisplay.size();
        String[] loadRecipeName = new String[size];
        String[] loadCookingTime = new String[size];
        String[] loadPreparationTime = new String[size];
        String[] loadRecipeType = new String[size];
        Integer[] loadImageID = new Integer[size];


        for(int iterator = 0; iterator < size; iterator++)
        {
            Recipe tempRecipe = recipesToDisplay.get(iterator);
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
