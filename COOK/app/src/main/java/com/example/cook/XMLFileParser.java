package com.example.cook;


import android.app.Activity;
import android.media.Image;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;


public class XMLFileParser {


    public void parseXMLFile(Activity context) throws IOException,
            XmlPullParserException {
        ArrayList<Recipe> recipes = new ArrayList<>();
        int id = 0;
        String name = null;
        String description = null;
        int prepareTime = 0;
        int cookingTime = 0;
        int recipeImage = 0;
        ArrayList<String> sbsDescription = null;
        Boolean[] tags = new Boolean[]{false, false, false, false, false, false, false,
                false, false, false};
        int idFavorite = 0;


        InputStream inputStream = context.getAssets().open("recipes_data.xml");
        XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
        XmlPullParser parser = xmlFactoryObject.newPullParser();
        parser.setInput(inputStream, null);
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        while(parser.next() != XmlPullParser.END_DOCUMENT){
            switch(parser.getEventType()){
                case XmlPullParser.START_TAG:
                    if("id".equals(parser.getName())) {
                        parser.next();
                        id = Integer.parseInt(parser.getText());
                    }
                    else if("name".equals(parser.getName())){
                        parser.next();
                        name = parser.getText();
                    }
                    else if("description".equals(parser.getName())){
                        parser.next();
                        description = parser.getText();
                    }
                    else if("cooking_time".equals(parser.getName())){
                        parser.next();
                        cookingTime = Integer.parseInt(parser.getText());
                    }
                    else if("preparation_time".equals(parser.getName())){
                        parser.next();
                        prepareTime = Integer.parseInt(parser.getText());
                    }
                    else if("sbs_description".equals(parser.getName())){
                        parser.next();
                        sbsDescription = new ArrayList<String>();
                    }
                    else if("step".equals((parser.getName()))) {
                        parser.next();
                        if (sbsDescription == null) {
                            sbsDescription = new ArrayList<String>();
                        }
                        sbsDescription.add(parser.getText());
                    }
                    else if("tags".equals(parser.getName())){
                        parser.next();
                        tags = getTagsForRecipeObject(parser.getText());
                    }
                    else if("image".equals(parser.getName()))
                    {
                        parser.next();
                        recipeImage = context.getResources().getIdentifier(parser.getText() ,
                                "drawable", context.getPackageName());
                        recipes.add(new Recipe(id, name, description, prepareTime, cookingTime,
                                recipeImage, sbsDescription, tags));
                    }
                    else if("idFavorite".equals(parser.getName())){
                        parser.next();
                        idFavorite = Integer.parseInt(parser.getText());
                        Recipe.favoriteRecipe.add(recipes.get(idFavorite));
                    }
                    break;
            }
        }
        Recipe.allRecipe = recipes;
    }

    private Boolean[] getTagsForRecipeObject(String stringTags){
        Boolean[] tags = new Boolean[]{false, false, false, false, false, false, false,
                false, false, false};
        if(stringTags.contains(Recipe.pastaString))
            tags[0] = true;
        if(stringTags.contains(Recipe.meatString))
            tags[1] = true;
        if(stringTags.contains(Recipe.dinnerString))
            tags[2] = true;
        if(stringTags.contains(Recipe.breakfastString))
            tags[3] = true;
        if(stringTags.contains(Recipe.sweetsString))
            tags[4] = true;
        if(stringTags.contains(Recipe.healthyString))
            tags[5] = true;
        if(stringTags.contains(Recipe.veganString))
            tags[6] = true;
        if(stringTags.contains(Recipe.lunchString))
            tags[7] = true;
        if(stringTags.contains(Recipe.fastFoodString))
            tags[8] = true;
        if(stringTags.contains(Recipe.soupString))
            tags[9] = true;
        return tags;
    }

}
