package com.mg_source.school;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mBlogList;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(R.string.studentComunity);
        Log.e("0","2");
/////////
        String c=getString(R.string.child);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child(c);
        Log.e("0","3");
        mDatabaseReference.keepSynced(true);
        Log.e("0","4");
        mBlogList = (RecyclerView) findViewById(R.id.student_list);
        Log.e("0","5");
        mBlogList.setHasFixedSize(true);
        Log.e("0","6");
        mBlogList.setLayoutManager(new LinearLayoutManager(this));
        Log.e("0","7");
/////////
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder {

        View mView;

        TextView student_name;
        TextView student_class;
        TextView student_note;
        ImageView student_img;

        public BlogViewHolder(final View itemView) {

            super(itemView);
            Log.e("d","0");
            mView = itemView;
            Log.e("d","1");
            student_name = (TextView) mView.findViewById(R.id.txt_name_row);
            Log.e("d","2");
            student_class = (TextView) mView.findViewById(R.id.txt_class_row);
            Log.e("d","3");
            student_note = (TextView) mView.findViewById(R.id.txt_note_row);
            Log.e("d","4");
            student_img = (ImageView) mView.findViewById(R.id.img_student_row);
            Log.e("d","5");
        }


        public void setName_(String name) {
            Log.e("y","0");
            student_name.setText(name);
        }
        public void setClass_(String class_) {
            Log.e("y","1");
            student_class.setText(class_);
        }
        public void setNote_(String note) {
            Log.e("y","2");
            student_note.setText(note);
        }
        public void setImg_(final Context context, final String img) {
            Log.e("y","3");
            //Picasso.with(context).load(img).into(post_img);
            Picasso.with(context).load(img).networkPolicy(NetworkPolicy.OFFLINE).into(student_img, new Callback() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onError() {
                    Picasso.with(context).load(img).into(student_img);
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("0","0");
        final FirebaseRecyclerAdapter<Student, BlogViewHolder> fbra = new FirebaseRecyclerAdapter<Student, BlogViewHolder>(
                Student.class,
                R.layout.row_student,
                BlogViewHolder.class,
                mDatabaseReference.orderByPriority()
        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Student model, int position) {
//                final String postKey = getRef(position).getKey();
                Log.e("0","1");
                viewHolder.setName_(model.getName());
                Log.e("0","-1");
                viewHolder.setClass_(model.getClass_());
                Log.e("0","-2");
                viewHolder.setNote_(model.getNote());
                Log.e("0","-3");
                viewHolder.setImg_(MainActivity.this, model.getImg());
                Log.e("0","-4");
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
//                        Toast.makeText(MainActivity.this, "ur in view", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        mBlogList.setAdapter(fbra);
    }
}
