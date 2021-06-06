package com.akb.tugas_uts_genap_2021_akb_if9_10118372;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// 5 juni 2021
// 10118372
// Rifqi Muhammad Rizqullah
// IF-9

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected( MenuItem item) {
            fragment = null;
            switch (item.getItemId()){
                case R.id.profile:
                    fragment = new FragmentProfile();
                    break;
                case R.id.diary:
                    fragment = new Fragment_Diary();
                    break;
                case R.id.info:
                    fragment = new Fragment_Info();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
        fragment = new FragmentProfile();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();

    }
}