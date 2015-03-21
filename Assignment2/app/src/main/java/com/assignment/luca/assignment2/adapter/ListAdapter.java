package com.assignment.luca.assignment2.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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
            vi = inflater.inflate(R.layout.list_row, null);

        //Getting view elements to populate
        ImageView thumb_imageView = (ImageView) vi.findViewById(R.id.list_image); // thumb image
        TextView fruitTextView = (TextView) vi.findViewById(R.id.fruitTextView);


        //Getting data from the map passed by the main activity
        HashMap <String,String> fruitRowMap = data.get(position);
        int fruitId = Integer.parseInt(fruitRowMap.get(IMAGE_ID));
        Drawable fruitDrawable = activity.getResources().getDrawable(fruitId);
        String fruitDescription = fruitRowMap.get(DESCRIPTION);
        int id = activity.getResources().getIdentifier(fruitDescription, "string", activity.getPackageName());
        String fruitDescriptionValue = id == 0 ? "" : (String) activity.getResources().getText(id);

        FruitImage fruitImage = new FruitImage(fruitId,fruitDescriptionValue);

        //Setting data collected
        Spannable spannableBody = getSpannable(fruitDescriptionValue);

        populateViews(thumb_imageView, fruitTextView,fruitDrawable, fruitImage, spannableBody);

        return vi;
    }

    private void populateViews(ImageView thumb_imageView, TextView fruitTextView, Drawable fruitDrawable, FruitImage fruitImage, Spannable spannableBody) {
        fruitTextView.setText(spannableBody);
        thumb_imageView.setImageDrawable(fruitDrawable);
        thumb_imageView.setTag(fruitImage);
    }

    private Spannable getSpannable(String fruitDescriptionValue) {
        Spannable spannableBody = new SpannableString(fruitDescriptionValue);
        spannableBody.setSpan(new ForegroundColorSpan(Color.RED),0,1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableBody.setSpan(new ForegroundColorSpan(Color.BLUE),1,fruitDescriptionValue.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableBody;
    }
}