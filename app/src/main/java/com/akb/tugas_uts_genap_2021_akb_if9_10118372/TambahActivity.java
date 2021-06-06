package com.akb.tugas_uts_genap_2021_akb_if9_10118372;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

// 6 juni 2021
// 10118372
// Rifqi Muhammad Rizqullah
// IF-9

public class TambahActivity extends AppCompatActivity {
    ImageButton button;
    EditText edtjudul;
    EditText edtkategori;
    EditText edtdeskripsi;
    Button btn_tambah;
    Button btn_delete;

    private DBHelper noteInterfaces;

    diary note = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_diary);
        note = (diary) getIntent().getSerializableExtra("Note");
        button = findViewById(R.id.back);
        edtjudul = findViewById(R.id.Judul);
        edtkategori = findViewById(R.id.Kategori);
        edtdeskripsi = findViewById(R.id.Deskripsi);
        btn_tambah = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        noteInterfaces = new DBHelper(this);

        button.setOnClickListener(v -> {
            finish();
        });

        if (note == null ){
            btn_delete.setVisibility(View.GONE);

            btn_tambah.setOnClickListener(v -> {
                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMM yyyy HH:mm",d.getTime());
                diary n = new diary(
                        d.getTime()+ "",
                        edtjudul.getText().toString(),
                        edtkategori.getText().toString(),
                        edtdeskripsi.getText().toString(),
                        date+ ""
                );

                noteInterfaces.create(n);
                finish();
            });
        }else {
            edtjudul.setText(note.getTitle());
            edtkategori.setText(note.getCategory());
            edtdeskripsi.setText(note.getDesc());

            btn_delete.setVisibility(View.VISIBLE);
            btn_tambah.setText("EDIT");

            btn_tambah.setOnClickListener(v -> {
                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMM yyyy HH:mm",d.getTime());

                note.setTitle(edtjudul.getText().toString());
                note.setCategory(edtkategori.getText().toString());
                note.setDesc(edtdeskripsi.getText().toString());
                note.setDate(date+"");
                noteInterfaces.update(note);
                finish();
            });

            btn_delete.setOnClickListener(v -> {
                noteInterfaces.delete(note.getId());
                finish();
            });
        }
    }
}
