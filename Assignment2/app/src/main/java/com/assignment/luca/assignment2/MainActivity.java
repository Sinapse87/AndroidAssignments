package com.assignment.luca.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.assignment.luca.assignment2.adapter.ListAdapter;
import com.assignment.luca.assignment2.model.FruitImage;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity {

    static final String IMAGE_ID = "id";
    static final String IMAGE_DESCRIPTION = "description";

    //Stores the list of imageViews
    ListView listView;

    //Converts layout in views and populate them with data stored in a list
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the content view to be layout.activity_main_portrait
        //Set the activity content from a layout resource.  The resource will be
        //inflated, adding all top-level views to the activity.
        setContentView(R.layout.activity_main_portrait);

        //Getting the array of images
        ArrayList<HashMap<String,String>> fruitImageList = new ArrayList<>();
        populateFruitData(fruitImageList);

        //Getting the listView view by id
        //Finds a view that was identified by the id attribute from the XML that
        //was processed in {@link #onCreate}.
        listView =(ListView)findViewById(R.id.listView);
        // Getting listAdapter by passing xml data ArrayList
        listAdapter =new ListAdapter(this, fruitImageList);
        /**
        * Sets the data behind this ListView.
                *
        * The ListAdapter which is responsible for maintaining the
        *        data backing this list and for producing a view to represent an
        *        item in that data set.*/
        listView.setAdapter(listAdapter);
    }

    public void openFruitView(View view){
        //Create an intent that contains the imageTag of the imaged clicked
        Intent intent = createIntentWithExtraData(view);
        //Start the Display Fruit Activity
        startActivityForResult(intent, 1);
    }

    private Intent createIntentWithExtraData(View view){
        ImageView thumbImageView = (ImageView) view;

        FruitImage fruitImage = (FruitImage) thumbImageView.getTag();
        int imageId = fruitImage.getId();
        String imageDescription = fruitImage.getDescription();


        //HOW DO I GET THE IMAGE ID ?
        Intent intent = new Intent(this,DisplayFruitActivity.class);
        intent.putExtra("imageId", imageId);
        intent.putExtra("imageDescription", imageDescription);
        return intent;
    }

    private void populateFruitData(ArrayList<HashMap<String, String>> fruitImageList) {
        HashMap<String,String> bananaMap = new HashMap<>();
        bananaMap.put(IMAGE_ID,""+(R.drawable.banana));
        bananaMap.put(IMAGE_DESCRIPTION,"Banana");
        HashMap<String,String> appleMap = new HashMap<>();
        appleMap.put(IMAGE_ID,""+(R.drawable.apple));
        appleMap.put(IMAGE_DESCRIPTION, "Apple");
        HashMap<String,String> kiwiMap = new HashMap<>();
        kiwiMap.put(IMAGE_ID,""+(R.drawable.kiwi));
        kiwiMap.put(IMAGE_DESCRIPTION,"Kiwi");
        HashMap<String,String> coconutMap = new HashMap<>();
        coconutMap.put(IMAGE_ID,""+(R.drawable.coconut));
        coconutMap.put(IMAGE_DESCRIPTION,"Coconut");
        HashMap<String,String> orangeMap = new HashMap<>();
        orangeMap.put(IMAGE_ID,""+(R.drawable.orange));
        orangeMap.put(IMAGE_DESCRIPTION,"Orange");
        HashMap<String,String> lemonMap = new HashMap<>();
        lemonMap.put(IMAGE_ID,""+(R.drawable.lemon));
        lemonMap.put(IMAGE_DESCRIPTION,"Lemon");
        HashMap<String,String> melonMap = new HashMap<>();
        melonMap.put(IMAGE_ID,""+(R.drawable.melon));
        melonMap.put(IMAGE_DESCRIPTION,"Melon");
        HashMap<String,String> pumpkingMap = new HashMap<>();
        pumpkingMap.put(IMAGE_ID,""+(R.drawable.pumpkin));
        pumpkingMap.put(IMAGE_DESCRIPTION,"Pumpkin");
        fruitImageList.add(bananaMap);
        fruitImageList.add(appleMap);
        fruitImageList.add(kiwiMap);
        fruitImageList.add(coconutMap);
        fruitImageList.add(orangeMap);
        fruitImageList.add(lemonMap);
        fruitImageList.add(melonMap);
        fruitImageList.add(pumpkingMap);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
