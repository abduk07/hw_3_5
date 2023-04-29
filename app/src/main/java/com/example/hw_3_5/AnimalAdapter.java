package com.example.hw_3_5;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hw_3_5.databinding.ItemAnimalBinding;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    ArrayList<Animal> list;
    AnimalClick animalClick;

    public AnimalAdapter(ArrayList<Animal> list, AnimalClick animalClick) {
        this.list = list;
        this.animalClick = animalClick;
    }

    @NonNull
    @Override
    public AnimalAdapter.AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnimalViewHolder(ItemAnimalBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.AnimalViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.itemView.setOnClickListener(view -> {
            animalClick.onClicked(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder {
        ItemAnimalBinding binding;

        public AnimalViewHolder(@NonNull ItemAnimalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(Animal animal) {
            binding.tvName.setText(animal.getName());
            binding.tvBreed.setText(animal.getBreed());
            binding.tvColor.setText(animal.getColor());
            Glide.with(binding.imageView).load(animal.getImage()).into(binding.imageView);
        }
    }
}
