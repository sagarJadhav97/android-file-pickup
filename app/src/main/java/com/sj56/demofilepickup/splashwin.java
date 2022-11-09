package com.sj56.demofilepickup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splashwin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashwin);
       // getSupportActionBar().hide();

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    Intent intent = new Intent(splashwin.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }

}