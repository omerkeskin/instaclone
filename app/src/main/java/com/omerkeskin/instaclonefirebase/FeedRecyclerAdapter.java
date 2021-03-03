package com.omerkeskin.instaclonefirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<PostHolder> {

    private ArrayList<String> userEmailFromFB;
    private ArrayList<String> userCommentFromFB;
    private ArrayList<String> userImageFromFB;

    public FeedRecyclerAdapter(ArrayList<String> userEmailFromFB, ArrayList<String> userCommentFromFB, ArrayList<String> userImageFromFB) {
        this.userEmailFromFB = userEmailFromFB;
        this.userCommentFromFB = userCommentFromFB;
        this.userImageFromFB = userImageFromFB;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.getTvRecComment().setText(userCommentFromFB.get(position));
        holder.getTvRecUsername().setText(userEmailFromFB.get(position));
        String url = userImageFromFB.get(position);
        ImageView imageView = holder.getIvRecPhoto();
        Picasso.get().load(url).into(imageView);
    }

    @Override
    public int getItemCount() {
        return this.userEmailFromFB.size();
    }
}
