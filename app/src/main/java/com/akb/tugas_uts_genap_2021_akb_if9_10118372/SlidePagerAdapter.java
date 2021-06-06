package com.akb.tugas_uts_genap_2021_akb_if9_10118372;

import android.icu.text.Transliterator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.ListFragment;

import java.util.List;

// 6 juni 2021
// 10118372
// Rifqi Muhammad Rizqullah
// IF-9

public class SlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentlist;

    public SlidePagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentlist) {
        super(fragmentManager);
        this.fragmentlist = fragmentlist;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }
}
