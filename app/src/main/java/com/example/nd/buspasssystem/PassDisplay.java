package com.example.nd.buspasssystem;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class PassDisplay extends AppCompatActivity {

    private TextView name,col,edu,ida,mobile,dob,address,fro,tos;
    private ImageView wimages;
    Button up;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pass);
        final String ssessionId= getIntent().getStringExtra("EXTRA_SESSION_ID");
        name=(TextView)findViewById(R.id.name);
        col=(TextView)findViewById(R.id.coll);
        edu=findViewById(R.id.education);
        ida=findViewById(R.id.marriage);
        dob=(TextView)findViewById(R.id.dob);
        address=(TextView)findViewById(R.id.occupation);
        fro=findViewById(R.id.email);
        tos=findViewById(R.id.approved_by);
        wimages=findViewById(R.id.profile);

        mobile=findViewById(R.id.mobileNumber);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseStorage=FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();
        storageReference.child("profile").child(firebaseAuth.getUid()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

            @Override
            public void onSuccess(Uri uri) {
                Toast.makeText(PassDisplay.this,"image loaded",Toast.LENGTH_SHORT).show();
                Picasso.get().load(uri).into(wimages);
            }
        });
        DatabaseReference databaseReference=firebaseDatabase.getReference("student").child(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userProfile userprofile=dataSnapshot.getValue(userProfile.class);
                name.setText(userprofile.getNameS());
                col.setText(userprofile.getCollegE());
                mobile.setText(userprofile.getMobileNo());
                dob.setText(userprofile.getDoB());
                address.setText(userprofile.getaDdress());
                fro.setText(userprofile.getFroM());
                tos.setText(userprofile.gettO());
                edu.setText(userprofile.getYearStudy());
                ida.setText(userprofile.getKeY());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PassDisplay.this,"could not connect",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
