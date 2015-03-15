package com.assignment.luca.assignment2.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.assignment.luca.assignment2.R;

import java.util.ArrayList;

public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Integer> data;

    //Instantiates a layout XML file into its corresponding View objects.
    // It is never used directly. Instead, use getLayoutInflater() or
    // getSystemService(String) to retrieve a standard LayoutInflater
    // instance that is already hooked up to the current context and
    // correctly configured for the device you are running on.
    private static LayoutInflater inflater = null;


    public LazyAdapter(Activity a, ArrayList<Integer> d) {
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
            vi = inflater.inflate(R.layout.list_row, null);

        //Getting the list view image
        ImageView thumb_image = (ImageView) vi.findViewById(R.id.list_image); // thumb image
        ImageView arrow_image = (ImageView) vi.findViewById(R.id.arrow);
        int fruitIdentifier = data.get(position);
        Drawable drawable = activity.getResources().getDrawable(fruitIdentifier);
        Drawable drawable1 = activity.getResources().getDrawable(R.drawable.arrow);
        thumb_image.setImageDrawable(drawable);
        arrow_image.setImageDrawable(drawable1);


        return vi;
    }
}