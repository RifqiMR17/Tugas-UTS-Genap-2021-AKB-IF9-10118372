package com.akb.tugas_uts_genap_2021_akb_if9_10118372;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// 5 juni 2021
// 10118372
// Rifqi Muhammad Rizqullah
// IF-9

public class FragmentInfo1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_info1, container, false);

        return root;
        }
}
