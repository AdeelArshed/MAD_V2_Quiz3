package com.example.mad_v2_quiz3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Update_Student extends AppCompatActivity {




    EditText etUpdateName,etUpdateEmail,etUpdateCellNo,etUpdateProgram,etUpdateInstitute;
    Button btnCancleUpdate,btnConfirmUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__student);
        init();

    }
    public void init()
    {

        etUpdateName=findViewById(R.id.etUpdateName);
        etUpdateEmail=findViewById(R.id.etUpdateEmail);
        etUpdateCellNo=findViewById(R.id.etUpdateCellNo);
        etUpdateProgram=findViewById(R.id.etUpdateProgram);
        etUpdateInstitute=findViewById(R.id.etUpdateInstitute);
        btnCancleUpdate=findViewById(R.id.btnCancleUpdate);
        btnConfirmUpdate=findViewById(R.id.btnConfirmUpdate);

    }
}