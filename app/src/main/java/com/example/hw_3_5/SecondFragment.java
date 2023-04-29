package com.example.hw_3_5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.hw_3_5.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getAnimal();
    }

    private void getAnimal() {
        Bundle bundle = this.getArguments();
        Animal animal = (Animal) bundle.getSerializable("animal");
        binding.finalName.setText(animal.getName());
        binding.finalBreed.setText(animal.getBreed());
        binding.finalColor.setText(animal.getColor());
        Glide.with(binding.finalImageView).load(animal.getImage()).into(binding.finalImageView);
    }
}