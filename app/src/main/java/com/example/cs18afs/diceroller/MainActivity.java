package com.example.cs18afs.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Generate();

    }
    void Generate(){
        Random r = new Random();
        n1 = r.nextInt();
        n2 = r.nextInt();
        Button btn1 = (Button)findViewById(R.id.btnN1);
        Button btn2 = (Button)findViewById(R.id.btnN2);
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

    public void on_btn2_click(View view)
    {
        if(n1<=n2)
            won();
        else
            lost();
        Generate();
    }

    public void on_btn1_click(View view)
    {
        if(n1>=n2)
            won();
        else
            lost();
        Generate();
    }

    void won(){
        Toast.makeText(getApplicationContext(),"You Won",Toast.LENGTH_SHORT).show();
    }
    void lost(){
        Toast.makeText(getApplicationContext(),"You Lost",Toast.LENGTH_SHORT).show();
    }
}
