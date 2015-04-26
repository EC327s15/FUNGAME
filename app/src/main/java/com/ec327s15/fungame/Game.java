package com.ec327s15.fungame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import android.content.SharedPreferences;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;




public class Game extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.ec327s15.fungame.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gamePrefs = getSharedPreferences(GAME_PREFS, 0);
    }

    public void sendScore(View view){
        Intent intent = new Intent(this,Highscore.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
        SharedPreferences.Editor scoreEdit = gamePrefs.edit();
        if (Integer.parseInt(message)>gamePrefs.getInt("currentscore",-1)){
            scoreEdit.putInt("currentscore", Integer.parseInt(message));
            scoreEdit.commit();
        }

        intent.putExtra(EXTRA_MESSAGE, Integer.toString(gamePrefs.getInt("currentscore",-1)));
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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

    private SharedPreferences gamePrefs;
    public static final String GAME_PREFS = "HighScoreFile";

}
