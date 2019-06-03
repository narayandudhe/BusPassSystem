package com.example.nd.buspasssystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MakePass extends AppCompatActivity {

    EditText tcost;
    TextView ids,sta,endd;
    Button bt;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_pass);
        final String seessionId= getIntent().getStringExtra("EXTRA_SESSION_ID");
        tcost=findViewById(R.id.tc);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("student").child(seessionId);
        ids=findViewById(R.id.id);
        sta=findViewById(R.id.start);
        endd=findViewById(R.id.end);
        bt=findViewById(R.id.button);
        ids.setText(seessionId);
        Calendar calendar = new GregorianCalendar(/* remember about timezone! */);
        sta.setText(calendar.getTime().toString());
        calendar.add(Calendar.DATE, 30);
        endd.setText(calendar.getTime().toString());
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st="Approved";
                String s=sta.getText().toString();
                String e=endd.getText().toString();
                String co=tcost.getText().toString();
                user usa=new user(s,e,co,st);
                databaseReference.child("startD").setValue(s);
                databaseReference.child("endD").setValue(e);
                databaseReference.child("cost").setValue(co);
                databaseReference.child("status").setValue(st);
                Toast.makeText(getApplicationContext(),"Pass Created",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
