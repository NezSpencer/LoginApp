package com.nezspencer.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        username = (TextView) findViewById(R.id.name);
        password = (TextView) findViewById(R.id.passwrd);

        if (getIntent().hasExtra(MainActivity.KEY_USERNAME) &&
                getIntent().hasExtra(MainActivity.KEY_PASSWRD)){

            String name = getIntent().getStringExtra(MainActivity.KEY_USERNAME);
            String pass = getIntent().getStringExtra(MainActivity.KEY_PASSWRD);
            username.setText(name);
            password.setText(pass);
        }




    }
}
