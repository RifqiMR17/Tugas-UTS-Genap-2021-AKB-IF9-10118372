package com.akb.tugas_uts_genap_2021_akb_if9_10118372;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

// 5 juni 2021
// 10118372
// Rifqi Muhammad Rizqullah
// IF-9

public class SplashScreen extends AppCompatActivity {
    Animation transisiAtas, transisiBawah;
    ImageView logo;
    TextView nama, nim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menghilangkan status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        // animasi
        transisiAtas = AnimationUtils.loadAnimation(this,R.anim.transisi_atas);
        transisiBawah = AnimationUtils.loadAnimation(this,R.anim.transisi_bawah);

        //hooks
        logo = findViewById(R.id.logo);
        nama = findViewById(R.id.nama);
        nim  = findViewById(R.id.nim);

        logo.setAnimation(transisiAtas);
        nama.setAnimation(transisiBawah);
        nim.setAnimation(transisiBawah);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3000L);
    }
}