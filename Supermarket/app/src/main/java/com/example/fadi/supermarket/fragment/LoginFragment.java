package com.example.fadi.supermarket.fragment;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.activity.HomeActivity;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_login, container, false);

        Button loginButton = (Button) myView.findViewById(R.id.finalLoginButton);
        final EditText nameET = (EditText) myView.findViewById(R.id.nameLogin);
        final EditText passwordET = (EditText) myView.findViewById(R.id.passwordLogin);
        final CheckBox rememberMeCheck = (CheckBox) myView.findViewById(R.id.rememberLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString();
                String password = passwordET.getText().toString();
                if(rememberMeCheck.isChecked()){

                    SharedPreferences userDetails = getContext().getSharedPreferences("userdetails", MODE_PRIVATE);
                    userDetails.putString("username", name);
                    userDetails.putString("password", password);
                    
                }
                Intent homeIntent = new Intent(getActivity(), HomeActivity.class);
                startActivity(homeIntent);

            }

        });
        return myView;
        // Inflate the layout for this fragment
    }


}
