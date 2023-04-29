package com.example.hw_3_5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw_3_5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_main, new FirstFragment()).commit();
    }
}