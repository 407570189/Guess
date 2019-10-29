package com.tom.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
        private EditText num;
        private TextView message;
        private TextView Guess;
        private Button zero;
        String TAG =MainActivity.class.getName();
        int secret =new Random().nextInt(10)+1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        num=findViewById(R.id.number);
        message =findViewById(R.id.message);
        Guess =findViewById(R.id.guess);
        zero=findViewById(R.id.reset);
        
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
            public void zero(View view){
                secret=new Random().nextInt(10)+1;
                num.setText("");
                message.setText("");
                zero.setVisibility(View.GONE);

            }
            public void turn(View view){
                Scanner scanner = new Scanner(System.in);
                int guess= Integer.parseInt(num.getText().toString());
                Log.d(TAG, "secret:"+secret);
                if(guess==secret){
                    message.setText("bingo");
                }
                else  if(guess<secret) {
                    message.setText("too small");
                }
                else  if(guess>secret){
                    message.setText(" too big");}
                    zero.setVisibility(View.VISIBLE);
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
    public void Guess(View view){


    }
}
