package com.example.cook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;

import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class AddRecipe extends AppCompatActivity {
    static String name;
    static String description;
    static int prep_time;
    static int cooking_time;
    static ArrayList<GuideStep> sbs_description;
    static Image food_picture;

    static Boolean[] tags = new Boolean[10];

    private CheckBox tag0, tag1, tag2, tag3, tag4, tag5, tag6, tag7, tag8, tag9;


    static ImageView recipe_image;

    public Boolean[] getTags() {
        return tags;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_recipe);
        Button add_picture_button = findViewById(R.id.add_picture);
        Button submit = findViewById(R.id.submitRecipe);
        final EditText input_name = findViewById(R.id.inputName);
        final EditText input_description = findViewById(R.id.inputDescription);
        final EditText input_prep_time = findViewById(R.id.inputPreparationTime);
        final EditText input_cooking_time = findViewById(R.id.inputCookingTime);
        final EditText input_sbs_description = findViewById(R.id.inputSbs);


        tag0 = (CheckBox) findViewById(R.id.tag0);
        tag1 = (CheckBox) findViewById(R.id.tag1);
        tag2 = (CheckBox) findViewById(R.id.tag2);
        tag3 = (CheckBox) findViewById(R.id.tag3);
        tag4 = (CheckBox) findViewById(R.id.tag4);
        tag5 = (CheckBox) findViewById(R.id.tag5);
        tag6 = (CheckBox) findViewById(R.id.tag6);
        tag7 = (CheckBox) findViewById(R.id.tag7);
        tag8 = (CheckBox) findViewById(R.id.tag8);
        tag9 = (CheckBox) findViewById(R.id.tag9);

        if (Recipe.edit_recipe == true) {
            input_name.setText(Recipe.recipe_to_edit.getName());
            input_description.setText(Recipe.recipe_to_edit.getDescription());
            input_prep_time.setText(String.valueOf(Recipe.recipe_to_edit.getPrep_time()));
            input_cooking_time.setText(String.valueOf(Recipe.recipe_to_edit.getCooking_time()));
            String sbs_tmp = "";
            for (GuideStep gs : Recipe.recipe_to_edit.getSBSDescription()) {
                sbs_tmp += (gs.getDescription() + "\n");
            }
            input_sbs_description.setText(sbs_tmp);

            tag0.setChecked(Recipe.recipe_to_edit.isPasta());
            tag1.setChecked(Recipe.recipe_to_edit.isMeat());
            tag2.setChecked(Recipe.recipe_to_edit.isDinner());
            tag3.setChecked(Recipe.recipe_to_edit.isBreakfast());
            tag4.setChecked(Recipe.recipe_to_edit.isSweets());
            tag5.setChecked(Recipe.recipe_to_edit.isHealthy());
            tag6.setChecked(Recipe.recipe_to_edit.isVegan());
            tag7.setChecked(Recipe.recipe_to_edit.isLunch());
            tag8.setChecked(Recipe.recipe_to_edit.isFast_food());
            tag9.setChecked(Recipe.recipe_to_edit.isSoup());

            tags[0] = Recipe.recipe_to_edit.isPasta();
            tags[1] = Recipe.recipe_to_edit.isMeat();
            tags[2] = Recipe.recipe_to_edit.isDinner();
            tags[3] = Recipe.recipe_to_edit.isBreakfast();
            tags[4] = Recipe.recipe_to_edit.isSweets();
            tags[5] = Recipe.recipe_to_edit.isHealthy();
            tags[6] = Recipe.recipe_to_edit.isVegan();
            tags[7] = Recipe.recipe_to_edit.isLunch();
            tags[8] = Recipe.recipe_to_edit.isFast_food();
            tags[9] = Recipe.recipe_to_edit.isSoup();
        } else {
            for (int i = 0; i < 10; i++) {
                tags[i] = false;
            }
        }

        tag0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag0.isChecked()) {
                    tags[0] = true;
                } else tags[0] = false;
            }
        });
        tag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag1.isChecked()) {
                    tags[1] = true;
                } else tags[1] = false;
            }
        });
        tag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag2.isChecked()) {
                    tags[2] = true;
                } else tags[2] = false;
            }
        });
        tag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag3.isChecked()) {
                    tags[3] = true;
                } else tags[3] = false;
            }
        });
        tag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag4.isChecked()) {
                    tags[4] = true;
                } else tags[4] = false;
            }
        });
        tag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag5.isChecked()) {
                    tags[5] = true;
                } else tags[5] = false;
            }
        });
        tag6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag6.isChecked()) {
                    tags[6] = true;
                } else tags[6] = false;
            }
        });
        tag7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag7.isChecked()) {
                    tags[7] = true;
                } else tags[7] = false;
            }
        });
        tag8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag8.isChecked()) {
                    tags[8] = true;
                } else tags[8] = false;
            }
        });
        tag9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag9.isChecked()) {
                    tags[9] = true;
                } else tags[9] = false;
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_name.getText().toString().isEmpty()) showError("recipe name");
                else if(input_description.getText().toString().isEmpty()) showError("recipe description");
                else if(input_prep_time.getText().toString().isEmpty()) showError("preparation time");
                else if(input_cooking_time.getText().toString().isEmpty()) showError("cooking time");
                else if(input_sbs_description.getText().toString().isEmpty()) showError("step by step description");
                else if(!checkTags()) showError("any tags");
                else
                {
                    name = input_name.getText().toString();
                    description = input_description.getText().toString();
                    prep_time = Integer.parseInt(input_prep_time.getText().toString());
                    cooking_time = Integer.parseInt(input_cooking_time.getText().toString());
                    sbs_description = new ArrayList<GuideStep>();
                    //TODO: find a way of remembering the id of steps while editing
                    //      (currently new ids are assigned and old ones dropped)
                    //      we also have to remember the old images! currently they will be deleted when editing here
                    for (String description : input_sbs_description.getText().toString().split("\\r?\\n")) {
                        sbs_description.add(new GuideStep(GuideStep.next_id, description, GuideStep.NO_PICTURE));
                    }

                    if (Recipe.edit_recipe == true) {
                        Recipe.recipe_to_edit.setName(name);
                        Recipe.recipe_to_edit.setDescription(description);
                        Recipe.recipe_to_edit.setPrep_time(prep_time);
                        Recipe.recipe_to_edit.setCooking_time(cooking_time);
                        Recipe.recipe_to_edit.setSBSDescription(sbs_description);

                        Recipe.recipe_to_edit.setPasta(tags[0]);
                        Recipe.recipe_to_edit.setMeat(tags[1]);
                        Recipe.recipe_to_edit.setDinner(tags[2]);
                        Recipe.recipe_to_edit.setBreakfast(tags[3]);
                        Recipe.recipe_to_edit.setSweets(tags[4]);
                        Recipe.recipe_to_edit.setHealthy(tags[5]);
                        Recipe.recipe_to_edit.setVegan(tags[6]);
                        Recipe.recipe_to_edit.setLunch(tags[7]);
                        Recipe.recipe_to_edit.setFast_food(tags[8]);
                        Recipe.recipe_to_edit.setSoup(tags[9]);

                    } else {
                        Recipe.new_recipe_added = true;
                    }

                    Intent go_back_to_main = new Intent(AddRecipe.this, MainActivity.class);
                    startActivity(go_back_to_main);

                    finish();
                }

                //MainActivity.recipes.add(new Recipe(100, name, description, prep_time,
                //       cooking_time, food_picture, sbs_description, getTags()));

                //Recipe new_recipe = new Recipe(100, name, description, prep_time,
                //       cooking_time, food_picture, sbs_description, getTags());

/*
                XMLFileParser parse = new XMLFileParser();

                try {
                    parse.XMLAddRecipe(current);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                }

*/
                //food_picture = input_picture.getIma

                //Test
                //description.setText(name);
            }
        });

        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //submit function

                //construct Recipe

                recipes recipe = new recipes(1, name, description, prep_time, cook_time, picture, tags);

                //add to recipes[]


                //save recipes in XML


            }
        });*/


        recipe_image = findViewById(R.id.imageView);

        add_picture_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri image_uri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(image_uri));
                recipe_image.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /*protected void submitRecipe() {
        submit_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("EditText", recipe_name.getText().toString());
                Log.v("EditText", recipe_cooking_time.getText().toString());
                Log.v("EditText", recipe_preparation_time.getText().toString());
                Log.v("EditText", recipe_Sbs.getText().toString());
            }

        });
    }*/

    private boolean checkTags()
    {
        for(int i = 0; i < 10; i++)
        {
            if(tags[i] == true) return true;
        }

        return false;
    }

    private void showError(String attribute)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddRecipe.this);
        builder.setTitle("You didn't enter " + attribute + ".");
        builder.setMessage("Please try again.");

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
