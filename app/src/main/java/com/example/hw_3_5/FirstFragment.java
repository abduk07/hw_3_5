package com.example.hw_3_5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hw_3_5.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements AnimalClick {
    FragmentFirstBinding binding;
    ArrayList<Animal> list;
    AnimalAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList();
        initAdapter();
    }

    private void initList() {
        list = new ArrayList<>();
        list.add(new Animal("https://yunavet.ru/wp-content/uploads/2020/05/otkuda_vzyalis_khaski_1.jpg", "ХУСКИ", "ХАСКИ", "БЕЛЫЙ"));
        list.add(new Animal("https://avatars.dzeninfra.ru/get-zen_doc/230233/pub_5b9a198e04327700ab9aa960_5b9a1b9051c1b900adf2df0c/scale_1200", "ЖАНДОС", "ОВЧАРКА", "ЧЕРНЫЙ"));
        list.add(new Animal("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2Oiv8AN1kqG5f-PuWOczLaWNaLISJLJa0Dw&usqp=CAU", "ГЕКТОР", "ДОБЕРМАН", "ЧЕРНЫЙ"));
    }

    private void initAdapter() {
        adapter = new AnimalAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClicked(int position) {
        Animal animal = list.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("animal", animal);
        Fragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_main, fragment).addToBackStack(null).commit();
    }
}