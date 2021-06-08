package com.example.mad_v2_quiz3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Student extends AppCompatActivity {

    EditText etAddName,etAddEmail,etAddCellNo,etAddProgram,etAddInstitute;
    Button btnCancleAdd,btnConfirmAdd;

    StdDB db=new StdDB(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student);
        init();



 btnConfirmAdd.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         String name, email, cell, program,institute;

         name=etAddName.getText().toString().trim();
         email=etAddEmail.getText().toString().trim();
         cell=etAddCellNo.getText().toString().trim();
         program=etAddProgram.getText().toString().trim();
         institute=etAddInstitute.getText().toString().trim();

         db.open();
         db.createEntry(name,email,cell,program,institute);

         AppData.students.clear();
    //    db.getData();
         db.close();
         MainActivity.myAdapter.notifyDataSetChanged();

         Intent intent=new Intent(Add_Student.this,MainActivity.class);
         startActivity(intent);

     }
 });


    }
    public void init()
    {

        etAddName=findViewById(R.id.etAddName);
        etAddEmail=findViewById(R.id.etAddEmail);
        etAddCellNo=findViewById(R.id.etAddCellNo);
        etAddProgram=findViewById(R.id.etAddProgram);
        etAddInstitute=findViewById(R.id.etAddInstitute);
        btnCancleAdd=findViewById(R.id.btnCancleAdd);
        btnConfirmAdd=findViewById(R.id.btnConfirmAdd);

    }

}