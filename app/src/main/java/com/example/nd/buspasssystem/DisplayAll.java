package com.example.nd.buspasssystem;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayAll extends AppCompatActivity {

    RecyclerView recyclerVieww;
    FirebaseDatabase firebaseDatabase1;
    DatabaseReference databaseReference1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all);

        recyclerVieww=findViewById(R.id.recyclerview);
        recyclerVieww.setHasFixedSize(true);
        recyclerVieww.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase1=FirebaseDatabase.getInstance();
        databaseReference1=firebaseDatabase1.getReference().child("student");
        FirebaseRecyclerAdapter<userProfile,ViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<userProfile, ViewHolder>(
                        userProfile.class,
                        R.layout.approve_row,
                        ViewHolder.class,
                        databaseReference1) {

                    @Override
                    protected void populateViewHolder(final ViewHolder viewHolder, final userProfile siteAssign, int position) {
                        viewHolder.setDetails(getApplicationContext(),siteAssign.getNameS(),siteAssign.getFroM(),siteAssign.gettO(),siteAssign.getStatus());
                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String x=siteAssign.getKeY();
                                Intent intent = new Intent(getBaseContext(), GetPass.class);
                                intent.putExtra("EXTRA_SESSION_ID", x);
                                startActivity(intent);
                            }
                        });
                    }
                };
        recyclerVieww.setAdapter(firebaseRecyclerAdapter);

    }

}
