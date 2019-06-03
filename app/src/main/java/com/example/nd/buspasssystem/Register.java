package com.example.nd.buspasssystem;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class Register extends AppCompatActivity {

    ImageView ivProfile;
    Button sup;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    EditText na,em,pas,ca,ba,fs,ts,mn,cl,ad;
    private static int PICK_IMAGE=123;
    Uri imagepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        na=findViewById(R.id.namee);
        ca=findViewById(R.id.cname);
        ba=findViewById(R.id.birth);
        fs=findViewById(R.id.fromstop);
        ts=findViewById(R.id.tostop);
        mn=findViewById(R.id.mnumber);
        cl=findViewById(R.id.classs);
        ad=findViewById(R.id.taddress);
        em=findViewById(R.id.temail);
        pas=findViewById(R.id.tpassword);
        sup=findViewById(R.id.btnRegister);
        ivProfile=findViewById(R.id.iamge);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("student");
        firebaseStorage=FirebaseStorage.getInstance();
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final String nam=na.getText().toString().trim();
               final String col=ca.getText().toString().trim();
               final String bir=ba.getText().toString().trim();
               final String fos=fs.getText().toString().trim();
               final String tos=ts.getText().toString().trim();
               final String mon=mn.getText().toString().trim();
               final String cls=cl.getText().toString().trim();
               final String ads=ad.getText().toString().trim();
                String eme=em.getText().toString().trim();
                String psaa=pas.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(eme,psaa).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            String ke=firebaseAuth.getUid().toString();
                            storageReference=firebaseStorage.getReference().child("profile").child(firebaseAuth.getUid());
                            UploadTask uploadTask=storageReference.putFile(imagepath);
                            uploadTask.addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(),"Image Upload  Fiels",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    Toast.makeText(getApplicationContext(),"Image Uploaded ",Toast.LENGTH_SHORT).show();
                                }
                            });
                            String st=" ";
                            userProfile us = new userProfile(nam,col,bir,fos,tos,mon,cls,ads,st,ke);
                            databaseReference.child(firebaseAuth.getUid()).setValue(us);
                            Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Image"),PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK && data.getData() != null)
        {
            imagepath=data.getData();
            Bitmap bitmap= null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imagepath);
                ivProfile.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
