package com.assignment.luca.assignment2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.assignment.luca.assignment2.adapter.LazyAdapter;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    static final String KEY_THUMB_URL = "thumb_url";

    ListView listView;
    LazyAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the content view to be layout.activity_main
        //Set the activity content from a layout resource.  The resource will be
        //inflated, adding all top-level views to the activity.
        setContentView(R.layout.activity_main);

        //Getting the array of images
        ArrayList<Integer> fruitImageList = new ArrayList<>();
        fruitImageList.add(R.drawable.apple);
        fruitImageList.add(R.drawable.banana);
        fruitImageList.add(R.drawable.kiwi);


        //Getting the listView view by id
        //Finds a view that was identified by the id attribute from the XML that
        //was processed in {@link #onCreate}.
        listView =(ListView)findViewById(R.id.list);
        // Getting listAdapter by passing xml data ArrayList
        listAdapter =new LazyAdapter(this, fruitImageList);
        /**
        * Sets the data behind this ListView.
                *
        * The ListAdapter which is responsible for maintaining the
        *        data backing this list and for producing a view to represent an
        *        item in that data set.*/
        listView.setAdapter(listAdapter);
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
