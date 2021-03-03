package com.omerkeskin.instaclonefirebase;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostHolder extends RecyclerView.ViewHolder {

    private TextView tvRecUsername;
    private TextView tvRecComment;
    private ImageView ivRecPhoto;

    public PostHolder(@NonNull View itemView) {
        super(itemView);
        tvRecUsername = itemView.findViewById(R.id.tvRecUsername);
        tvRecComment = itemView.findViewById(R.id.tvRecComment);
        ivRecPhoto = itemView.findViewById(R.id.ivRecPhoto);
    }

    public TextView getTvRecUsername() {
        return tvRecUsername;
    }

    public TextView getTvRecComment() {
        return tvRecComment;
    }

    public ImageView getIvRecPhoto() {
        return ivRecPhoto;
    }
}
