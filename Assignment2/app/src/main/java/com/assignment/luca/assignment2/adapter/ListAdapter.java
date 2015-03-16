package com.assignment.luca.assignment2.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.luca.assignment2.R;
import com.assignment.luca.assignment2.model.FruitImage;

import java.util.ArrayList;
import java.util.HashMap;

public class ListAdapter extends BaseAdapter {

    static final String IMAGE_ID = "id";
    static final String DESCRIPTION = "description";
    static final int BANANA_ID = 1;

    private Activity activity;
    private ArrayList<HashMap<String,String>> data;

    //Instantiates a layout XML file into its corresponding View objects.
    // It is never used directly. Instead, use getLayoutInflater() or
    // getSystemService(String) to retrieve a standard LayoutInflater
    // instance that is already hooked up to the current context and
    // correctly configured for the device you are running on.
    private static LayoutInflater inflater = null;


    public ListAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data = d;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null) //Creating the imageView from the list view layout
            vi = inflater.inflate(R.layout.list_row_portrait, null);

        //Getting view elements to populate
        ImageView thumb_imageView = (ImageView) vi.findViewById(R.id.list_image); // thumb image
        TextView fruitTextView = (TextView) vi.findViewById(R.id.fruitTextView);
        ImageView arrow_imageView = (ImageView) vi.findViewById(R.id.arrow);

        //Getting data from the map passed by the main activity
        HashMap <String,String> fruitRowMap = data.get(position);
        int fruitId = Integer.parseInt(fruitRowMap.get(IMAGE_ID));
        Drawable fruitDrawable = activity.getResources().getDrawable(fruitId);
        Drawable arrowDrawable = activity.getResources().getDrawable(R.drawable.arrow);
        String fruitDescription = fruitRowMap.get(DESCRIPTION);
        int id = activity.getResources().getIdentifier(fruitDescription, "string", activity.getPackageName());
        String value = id == 0 ? "" : (String) activity.getResources().getText(id);

        FruitImage fruitImage = new FruitImage(fruitId,value);

        //Setting data collected
        fruitTextView.setText(fruitDescription);
        thumb_imageView.setImageDrawable(fruitDrawable);
        thumb_imageView.setTag(fruitImage);
        arrow_imageView.setImageDrawable(arrowDrawable);

        return vi;
    }
}