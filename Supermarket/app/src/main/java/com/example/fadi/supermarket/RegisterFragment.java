package com.example.fadi.supermarket;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_register, container, false);

        Button registerButton = (Button) myView.findViewById(R.id.finalRegisterButton);
        final EditText nameET = (EditText) myView.findViewById(R.id.nameRegister);
        final EditText passwordET = (EditText) myView.findViewById(R.id.passwordRegister);
        final EditText emailET = (EditText) myView.findViewById(R.id.emailRegister);
        final EditText passwordCET = (EditText) myView.findViewById(R.id.passwordCRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString();
                String password = passwordET.getText().toString();
                String email = emailET.getText().toString();
                String passwordC = passwordCET.getText().toString();

                Intent homeIntent = new Intent(getActivity(),HomeActivity.class);
                startActivity(homeIntent);
            }

        });
        // Inflate the layout for this fragment
        return myView;
    }

}
