package com.example.sqliteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<Users> usersArrayList;
    private Context context;

    public UserAdapter(ArrayList<Users> usersArrayList, Context context) {
        this.usersArrayList = usersArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutitem, parent, false);
        return new UserViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        Users users=usersArrayList.get(position);
        holder.name.setText(users.getName());
        holder.userName.setText(users.getUser_name());
        holder.password.setText(users.getPassword());

    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView name,userName,password;

        public UserViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textname);
            userName = itemView.findViewById(R.id.textuserName);
            password = itemView.findViewById(R.id.textpassword);
        }
    }
}
