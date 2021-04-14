package com.example.coursehomeworkthree;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    private ArrayList<UserClass> users = new ArrayList<>();
    public static final String USER_DATA_EXTRA = "user_data_extra";
    UserClickListener userClickListener;


    public UserRecyclerViewAdapter(UserClickListener userClickListener) {
        this.userClickListener = userClickListener;
    }

    @NonNull
    @Override
    public UserRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card,parent, false);
        return new UserRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecyclerViewAdapter.ViewHolder holder, int position) {
        Picasso.get().load(users.get(position).getImg_url()).into(holder.userImage);
        holder.email.setText(users.get(position).getEmail());
        holder.username.setText(users.get(position).getUsername());
        holder.dateOfBirth.setText(users.get(position).getDateOfBirth());
        holder.deleteBtn.setImageResource(R.drawable.ic_delete_icon);
    }

    public void setUsers(ArrayList<UserClass> users){
        this.users = users;
        notifyDataSetChanged();
    }

    public void removeUser(int position){
        users.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    public ArrayList<UserClass> getUsers(){
        return users;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView userImage, deleteBtn;
        private TextView username, dateOfBirth, email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            username = itemView.findViewById(R.id.usernameTv);
            dateOfBirth = itemView.findViewById(R.id.dateOfBirthTv);
            email = itemView.findViewById(R.id.emailTv);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            itemView.setOnClickListener(view -> {
                userClickListener.onUserClick(view, getAdapterPosition());
            });
            deleteBtn.setOnClickListener(view -> {
                userClickListener.onDeleteClick(getAdapterPosition());
            });
        }
    }

    public interface UserClickListener{
        void onUserClick(View v, int position);
        void onDeleteClick(int position);
    }
}
