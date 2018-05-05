package com.example.fadi.supermarket.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.activity.HomeActivity;
import com.example.fadi.supermarket.async.task.AsyncResponse;
import com.example.fadi.supermarket.async.task.SignInAsyncTaskRunner;

public class LoginFragment extends Fragment implements AsyncResponse {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_login, container, false);

        Button loginButton = (Button) myView.findViewById(R.id.finalLoginButton);
        final EditText emailET = (EditText) myView.findViewById(R.id.emailLogin);
        final EditText passwordET = (EditText) myView.findViewById(R.id.passwordLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();

                SignInAsyncTaskRunner signInAsyncTaskRunner = new SignInAsyncTaskRunner(LoginFragment.this);
                signInAsyncTaskRunner.execute(email, password);
            }
        });

        return myView;
        // Inflate the layout for this fragment
    }

    @Override
    public void processData(Object data) {

        Boolean successfullyLoggedIn = (Boolean) data;

        if (successfullyLoggedIn) {
            Intent homeIntent = new Intent(getActivity(), HomeActivity.class);
            startActivity(homeIntent);
        } else {
            // TODO: show error message to user, that login failed
        }
    }
}
