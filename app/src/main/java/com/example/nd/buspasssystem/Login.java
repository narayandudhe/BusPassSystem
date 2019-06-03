package com.example.nd.buspasssystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity{
    private FirebaseAuth firebaseAuth;
    Toolbar toolbar;
    EditText email,password;
    CheckBox checkBox;
    Button signin;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();


        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        signin =findViewById(R.id.btnLogin);
        signup = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        if(user != null){
            String x=user.getEmail().toString();
            if(x.equals("admin@bus.com"))
            {

                startActivity(new Intent(Login.this, Admin.class));
                finish();
            }
            else
            {

                startActivity(new Intent(Login.this, Student.class));
                finish();
            }
        }


        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Register.class);
                startActivity(i);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(email.getText().toString(),password.getText().toString());
            }
        });
    }

    private void validate(final String username, String password) {
        firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    if (username.equals("admin@bus.com"))
                    {
                        startActivity(new Intent(Login.this, Admin.class));
                        Toast.makeText(Login.this, "Admin Login Success", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    {
                        startActivity(new Intent(Login.this, Student.class));
                        Toast.makeText(Login.this, "normal Login Success", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                else
                {
                    Toast.makeText(Login.this,"Please Provide Correct Details",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}