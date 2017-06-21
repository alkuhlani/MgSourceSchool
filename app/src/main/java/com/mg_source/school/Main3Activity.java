package com.mg_source.school;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends AppCompatActivity {
    private Firebase mFB;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button m= (Button) findViewById(R.id.button2);
        Firebase.setAndroidContext(this);
        mFB=new Firebase("https://school-ec4fb.firebaseio.com/ahm");
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("allloh");


        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference f=mDatabaseReference.push();
                f.child("ahmed").setValue("homady");
                final DatabaseReference d=mDatabaseReference.child("s");
//                Toast.makeText(Main3Activity.this,mDatabaseReference.getKey()+"d",Toast.LENGTH_SHORT).show();
//                Toast.makeText(Main3Activity.this,mDatabaseReference.getRoot()+"dd",Toast.LENGTH_SHORT).show();
//                Toast.makeText(Main3Activity.this,mDatabaseReference.getRoot().getKey()+"3",Toast.LENGTH_SHORT).show();
                Firebase mFBchild=mFB.child("naser");
                mFBchild.setValue("mansor");

                mDatabaseReference.child("yain").setValue("noarah");
                DatabaseReference k=d.push();

       startActivity(new Intent(Main3Activity.this,MainActivity.class));
            }
        });
    }
}
