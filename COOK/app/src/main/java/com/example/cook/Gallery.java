package com.example.cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {

                switch(pos) {
                    case 0:
                        AddRecipe.food_picture = "apple";
                        break;
                    case 1:
                        AddRecipe.food_picture = "bananabread";
                        break;
                    case 2:
                        AddRecipe.food_picture = "bolognese";
                        break;
                    case 3:
                        AddRecipe.food_picture = "friedeggs";
                        break;
                    case 4:
                        AddRecipe.food_picture = "garlichicken";
                        break;
                    case 5:
                        AddRecipe.food_picture = "pancakes";
                        break;
                    case 6:
                        AddRecipe.food_picture = "pizza";
                        break;
                    case 7:
                        AddRecipe.food_picture = "potatosoup";
                        break;
                    case 8:
                        AddRecipe.food_picture = "quiche";
                        break;
                    case 9:
                        AddRecipe.food_picture = "tarator";
                        break;
                    case 10:
                        AddRecipe.food_picture = "tomatosalad";
                        break;
                    case 11:
                        AddRecipe.food_picture = "vegsoup";
                        break;
                }

                AddRecipe.select_image = true;
                Intent go_back_to_add_recipe = new Intent(Gallery.this, AddRecipe.class);
                startActivity(go_back_to_add_recipe);


                finish();
            }
        });
    }
}
