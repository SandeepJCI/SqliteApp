package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private DataBaseHandler dataBaseHandler;

    EditText editName,editUserName,editPassword;
    Button insertButton,nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseHandler=new DataBaseHandler(MainActivity.this);
        editName=(EditText)findViewById(R.id.editTextName);
        editUserName=(EditText)findViewById(R.id.editTextUserName);
        editPassword=(EditText)findViewById(R.id.editTextPassword);
        insertButton=(Button) findViewById(R.id.insertBtn);
        nextButton=(Button) findViewById(R.id.nextBtn);


        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=editName.getText().toString();
                String useername=editUserName.getText().toString();
                String pass=editPassword.getText().toString();

                dataBaseHandler.addNewUser(new Users(useername,name,pass));

                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                editName.setText("");
                editUserName.setText("");
                editPassword.setText("");
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, UsersListActivity.class);
                startActivity(intent);
            }
        });
    }
}