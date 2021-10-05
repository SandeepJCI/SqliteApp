package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class UsersListActivity extends AppCompatActivity {

    private DataBaseHandler dataBaseHandler;
    private RecyclerView recyclerView;
    UserAdapter userAdapter;
    ArrayList<Users> usersArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        recyclerView = findViewById(R.id.recyclerViewUsers);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UsersListActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        dataBaseHandler=new DataBaseHandler(UsersListActivity.this);
        usersArrayList  = new ArrayList<>();

        usersArrayList=dataBaseHandler.readUsers();

        userAdapter = new UserAdapter(usersArrayList, UsersListActivity.this);

        recyclerView.setAdapter(userAdapter);
    }
}