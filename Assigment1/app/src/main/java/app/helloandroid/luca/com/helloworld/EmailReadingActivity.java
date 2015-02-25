package app.helloandroid.luca.com.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class EmailReadingActivity extends ActionBarActivity {

    private RelativeLayout emailReadingLayout;

    int pageCounter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emailreadinglayout);
        emailReadingLayout=(RelativeLayout)findViewById(R.id.emailReadingLayout);
        populateTextViewListWithIntentExtraData();
    }


    private void populateTextViewListWithIntentExtraData() {
        Intent intent = getIntent();
        ArrayList<EditText> editTextArrayList = extractTextViewsFromLayout();
        for (EditText editText : editTextArrayList){
            String textFieldString = editText.getText().toString();
            String intentExtraDataEditText = intent.getStringExtra(String.valueOf(editText.getId()));
            if (intentExtraDataEditText!=null) {
                  textFieldString = textFieldString.concat("  " + intentExtraDataEditText);
            }
            Spannable spannableBody = new SpannableString(textFieldString);
            spannableBody.setSpan(new ForegroundColorSpan(Color.RED),0,editText.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            editText.setText(spannableBody);
        }
    }

    private ArrayList<EditText> extractTextViewsFromLayout() {
        ArrayList<EditText> myEditTextList = new ArrayList<>();
        for( int i = 0; i < emailReadingLayout.getChildCount(); i++ )
            if( emailReadingLayout.getChildAt( i ) instanceof EditText)
                myEditTextList.add( (EditText) emailReadingLayout.getChildAt( i ) );
        return myEditTextList;
    }

    public void backToEmailComposition(View backButton){
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_email_reading, menu);
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

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        pageCounter = savedInstanceState.getInt("pageCounter");
        Log.i("EmailReading counter",String.valueOf(pageCounter));
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("pageCounter", pageCounter);

    }
}
