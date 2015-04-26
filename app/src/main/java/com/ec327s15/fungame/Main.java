package com.ec327s15.fungame;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

public class Main extends Activity implements OnClickListener {

    private static final String TAG_DEBUG = Main.class.getName();
    private Button button;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);gamePrefs = getSharedPreferences(GAME_PREFS, 0);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        gamePrefs = getSharedPreferences(GAME_PREFS, 0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        setContentView(R.layout.activity_main);


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
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button :
            {
                Intent gameActivity = new Intent(Main.this,Game.class);
                startActivity(gameActivity);

                break;
            }
            case R.id.button2 :
            {
                Intent intent = new Intent(Main.this,MainHighScore.class);
                intent.putExtra(EXTRA_MESSAGE, Integer.toString(gamePrefs.getInt("currentscore",-1)));
                startActivity(intent);
            }
        }
    }




    private SharedPreferences gamePrefs;
    public static final String GAME_PREFS = "HighScoreFile";
    public final static String EXTRA_MESSAGE = "com.ec327s15.fungame.MESSAGE";
}

