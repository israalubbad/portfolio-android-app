package com.example.portfolio_project;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView rvBlog = findViewById(R.id.rvBlog);
        rvBlog.setLayoutManager(new LinearLayoutManager(this));

        List<String[]> posts = new ArrayList<>();
        posts.add(new String[]{"My First Post", "Welcome to my portfolio blog"});
        posts.add(new String[]{"Learning Git", "Notes about branches and GitFlow"});
        posts.add(new String[]{"Android Apps", "Building apps with Java"});

        rvBlog.setAdapter(new BlogAdapter(posts));
    }
}