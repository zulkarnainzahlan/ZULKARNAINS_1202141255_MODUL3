package com.deqode.android.zulkarnains_1202141255_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by Naim on 2/28/2018.
 */
//tes
public class ItemMenu {
    private String judul, info, detail;
    private int gambar;

    public ItemMenu(String judul, String info, String detail, int gambar) {
        this.judul = judul;
        this.info = info;
        this.detail = detail;
        this.gambar = gambar;
    }

    public static Intent toClick(Context context, String title, String desc, @DrawableRes int img){
        Intent in = new Intent(context, DetailDaftarAir.class);
        in.putExtra("EXTRA_TITLE",title);
        in.putExtra("EXTRA_DESC",desc);
        in.putExtra("EXTRA_IMG",img);
        return in;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
