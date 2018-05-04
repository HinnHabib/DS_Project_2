package com.example.fadi.supermarket.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fadi.supermarket.fragments.LoginFragment;
import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.fragments.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment loginFragment = new LoginFragment();
        RegisterFragment registerFragment = new RegisterFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        setTitle("Login Screen");
        setContentView(R.layout.activity_main);

        fragmentTransaction.add(R.id.linearLayout2, loginFragment, "loginFragment");
        fragmentTransaction.commit();

        final Button registerChoice = (Button) findViewById(R.id.registerButton);
        final Button loginChoice = (Button) findViewById(R.id.loginButton);


        loginChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginFragment loginFragment = new LoginFragment();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.remove(fragmentManager2.findFragmentByTag("registerFragment"));
                fragmentTransaction2.add(R.id.linearLayout2, loginFragment, "loginFragment");
                fragmentTransaction2.commit();

            }
        });

        registerChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterFragment registerFragment = new RegisterFragment();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.remove(fragmentManager2.findFragmentByTag("loginFragment"));
                fragmentTransaction2.add(R.id.linearLayout2, registerFragment, "registerFragment");
                fragmentTransaction2.commit();
            }
        });

    }
}
