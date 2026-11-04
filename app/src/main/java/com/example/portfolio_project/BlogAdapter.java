package com.example.portfolio_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {

    private final List<String[]> posts;

    public BlogAdapter(List<String[]> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_blog, parent, false);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        String[] post = posts.get(position);
        holder.tvTitle.setText(post[0]);
        holder.tvDescription.setText(post[1]);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class BlogViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription;

        BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}