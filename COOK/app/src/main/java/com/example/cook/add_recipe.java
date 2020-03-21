package com.example.cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class add_recipe extends AppCompatActivity {

    ImageView recipe_image;
    EditText recipe_name = findViewById(R.id.inputName);
    EditText recipe_cooking_time = findViewById(R.id.inputCookingTime);
    EditText recipe_preparation_time = findViewById(R.id.inputPreparationTime);
    EditText recipe_Sbs = findViewById(R.id.inputSbs);
    Button submit_btn = findViewById(R.id.submitRecipe);

    String name;
    int cooking_time;
    int preparationTime;
    String sbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        Button add_picture_button = findViewById(R.id.add_picture);
        recipe_image = findViewById(R.id.imageView);

        add_picture_button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }});
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
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



    protected void submitRecipe() {
        submit_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("EditText", recipe_name.getText().toString());
                Log.v("EditText", recipe_cooking_time.getText().toString());
                Log.v("EditText", recipe_preparation_time.getText().toString());
                Log.v("EditText", recipe_Sbs.getText().toString());
            }
            
        });
    }
}
