package com.akb.tugas_uts_genap_2021_akb_if9_10118372;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// 6 juni 2021
// 10118372
// Rifqi Muhammad Rizqullah
// IF-9

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "db_note", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_diary (id TEXT,judul TEXT,kategori TEXT ,deskripsi TEXT,tanggal TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tbl_diary");
    }

    public Cursor read() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM tbl_diary ",null);
    }


    public boolean create(diary diary) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO tbl_diary VALUES ('"+diary.getId()+"','"+diary.getTitle()+"','"+diary.getCategory()+"','"+diary.getDesc()+"','"+diary.getDate()+"')");
        return true;
    }

    public boolean update(diary diary) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE tbl_note SET title ='"+diary.getTitle()+"' , category = '"+diary.getCategory()+"' , description = '"+diary.getDesc()+"' , date = '"+diary.getDate()+"' WHERE id='"+diary.getId()+"'");
        return true;
    }

    public boolean delete(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM tbl_diary WHERE id='"+id+"'");
        return true;
    }
}
