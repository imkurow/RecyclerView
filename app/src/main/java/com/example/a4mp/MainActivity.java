package com.example.a4mp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvHeroes;
    private ArrayList list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));

        list.addAll(getListHeroes());

        showRecyclerList();

    }

    private void showRecyclerList() {
        ListHeroAdapter adapter = new ListHeroAdapter(this, list);
        rvHeroes.setAdapter(adapter);

    }

    public ArrayList getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_desc);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);


        ArrayList listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Heroes hero = new Heroes();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));

            listHero.add(hero);
        }
        return listHero;
    }
}