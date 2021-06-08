package com.example.mad_v2_quiz3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements StdAdapter.ItemClicked {


    FloatingActionButton fabAdd;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    public static RecyclerView.Adapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAdd=findViewById(R.id.fabAdd);

        recyclerView=findViewById(R.id.rvStudentList);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter=new StdAdapter(this,AppData.students);
        recyclerView.setAdapter(myAdapter);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Add_Student.class);

                startActivity(intent);
                finish();


            }
        });

    }

    @Override
    public void onRemoveClicked(int index) {

    }

    @Override
    public void onItemClicked(int index) {

    }

    @Override
    public void onEditClicked(int index) {

    }
}