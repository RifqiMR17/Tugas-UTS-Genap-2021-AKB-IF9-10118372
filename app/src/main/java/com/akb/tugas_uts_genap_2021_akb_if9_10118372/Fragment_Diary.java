package com.akb.tugas_uts_genap_2021_akb_if9_10118372;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

// 6 juni 2021
// 10118372
// Rifqi Muhammad Rizqullah
// IF-9

public class Fragment_Diary extends Fragment{
    private ArrayList<diary> diaries;
    private DBHelper dbHelper;
    private DiaryAdapter diaryAdapter;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary1, container, false);

        FloatingActionButton button_add = view.findViewById(R.id.btn_add);
        recyclerView = view.findViewById(R.id.mynote);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), TambahActivity.class);
                requireContext().startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        read();

    }

    @Override
    public void onResume() {
        super.onResume();
        read();
    }


    private void read(){
        diaries = new ArrayList<diary>();
        dbHelper = new DBHelper(getContext());
        Cursor cursor = dbHelper.read();
        if(cursor.moveToFirst()){
            do {
                diary n = new diary(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );

                diaries.add(n);
            }while (cursor.moveToNext());
        }
        diaryAdapter = new DiaryAdapter(diaries);
        recyclerView.setAdapter(diaryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
}
