package app.helloandroid.luca.com.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class EmailCompositionActivity extends ActionBarActivity {

    private RelativeLayout emailCompositionLayout;

    int pageCounter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emailcompositionlayout);
        emailCompositionLayout=(RelativeLayout)findViewById(R.id.emailCompositionLayout);
        Log.i("EmailCompositionActivit","onCreate called");
    }

    public void sendEmail(View view){
        Intent intent = createIntentWithExtraData();
        startActivityForResult(intent,1);
    }

    private Intent createIntentWithExtraData(){
        ArrayList<EditText> editTextArrayList = extractTextViewsFromLayout();
        Intent intent = new Intent(this,EmailReadingActivity.class);
        for (EditText editText : editTextArrayList){
            intent.putExtra(String.valueOf(editText.getId()),editText.getText().toString());
        }
        return intent;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("EmailCompositionActivit", "onActivityResult called");
    }

    public void clearContent (View view){
        ArrayList<EditText> myEditTextList = extractTextViewsFromLayout();
        for (EditText editText : myEditTextList){
            editText.getText().clear();
        }
    }

    private ArrayList<EditText> extractTextViewsFromLayout() {
        ArrayList<EditText> myEditTextList = new ArrayList<>();
        for( int i = 0; i < emailCompositionLayout.getChildCount(); i++ )
            if( emailCompositionLayout.getChildAt( i ) instanceof EditText)
                myEditTextList.add( (EditText) emailCompositionLayout.getChildAt( i ) );
        return myEditTextList;
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("EmailCompositionActivit", "onStart called");
    }

    @Override
    protected void onResume(){
        super.onResume();
        pageCounter++;
        Log.i("EmailCompositionActivit", "onResume called ");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("EmailCompositionActivit", "OnPause called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("EmailCompositionActivit", "OnStop called");
    }

    @Override
    protected void onDestroy (){
        super.onDestroy();
        Log.i("EmailCompositionActivit", "OnDestroy called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("EmailCompositionActivit", "onOptionsItemSelected called");
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
        Log.i("EmailComp counter",String.valueOf(pageCounter));
    }

    /* <p>The default implementation takes care of most of the UI per-instance
    * state for you by calling {@link android.view.View#onSaveInstanceState()} on each
    * view in the hierarchy that has an id, and by saving the id of the currently
    * focused view (all of which is restored by the default implementation of
            * {@link #onRestoreInstanceState}).  If you override this method to save additional
    * information not captured by each individual view, you will likely want to
    * call through to the default implementation, otherwise be prepared to save
    * all of the state of each view yourself.
    */
    //I am saving a page counter for educational purpose only. The textview will be automatically
    //restored as stated above !
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("pageCounter", pageCounter);

    }
}
