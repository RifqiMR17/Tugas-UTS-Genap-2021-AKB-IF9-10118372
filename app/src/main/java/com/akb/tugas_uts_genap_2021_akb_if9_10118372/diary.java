package com.akb.tugas_uts_genap_2021_akb_if9_10118372;

// 6 juni 2021
// 10118372
// Rifqi Muhammad Rizqullah
// IF-9

public class diary {
    String id;
    String judul;
    String kategori;
    String deskripsi;
    String tanggal;

    public diary(String id, String title, String category, String desc, String date) {
        this.id = id;
        this.judul = judul;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.tanggal = tanggal;
    }

    public String getCategory() {
        return kategori;
    }

    public void setCategory(String category) {
        this.kategori = kategori;
    }

    public String getDate() {
        return tanggal;
    }

    public void setDate(String date) {
        this.tanggal = tanggal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return judul;
    }

    public void setTitle(String title) {
        this.judul = judul;
    }

    public String getDesc() {
        return deskripsi;
    }

    public void setDesc(String desc) {
        this.deskripsi = deskripsi;
    }
}
