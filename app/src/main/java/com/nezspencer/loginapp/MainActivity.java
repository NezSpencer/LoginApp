package com.nezspencer.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText usernameEditText;
    private EditText passwordEditText;

    private static final String CORRECT_USERNAME = "eze";
    private static final String CORRECT_PASSWORD = "1234";

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWRD = "passwrd";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.login);
        usernameEditText = (EditText) findViewById(R.id.username_edit);
        passwordEditText = (EditText) findViewById(R.id.password_edit);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password))
                    verfiyLogin(name,password);
            }
        });
    }

    public void verfiyLogin(String username, String password){

        if (username.equalsIgnoreCase(CORRECT_USERNAME) &&
                password.equalsIgnoreCase(CORRECT_PASSWORD)){


            Intent detailIntent = new Intent(MainActivity.this,DetailActivity.class);

            detailIntent.putExtra(KEY_USERNAME,username);
            detailIntent.putExtra(KEY_PASSWRD,password);

            startActivity(detailIntent);
        }

        if (!username.equalsIgnoreCase(CORRECT_USERNAME))
            usernameEditText.setError("your username is wrong");
        else
            passwordEditText.setError("your password is wrong");
    }

}
