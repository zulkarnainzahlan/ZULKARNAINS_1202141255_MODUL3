package com.deqode.android.zulkarnains_1202141255_modul3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Naim on 2/28/2018.
 */

public class DetailDaftarAir extends AppCompatActivity {
    private Button tambah, kurang;
    private ImageView progress, gambar;
    private TextView judul, Detail, Stats;
    private int level =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_daftar_air);

        //Initialize the views
        tambah = findViewById(R.id.Tambah);
        kurang = findViewById(R.id.Kurang);
        progress = findViewById(R.id.isiBatre);

        judul = findViewById(R.id.lblJudul);
        Detail = findViewById(R.id.lblDetail);
        gambar = findViewById(R.id.gambar);
        Stats = findViewById(R.id.Status);

        Intent in = getIntent();
        String title=in.getStringExtra("etitle");
        String description=in.getStringExtra("edesc");
        if(description.length()<1){description="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ut tincidunt dui. Etiam et tincidunt dolor. Phasellus eu rhoncus sem. Suspendisse laoreet dolor eu nisi dictum congue id ut ipsum. Etiam sagittis sodales urna. Sed condimentum arcu at pretium laoreet. Nam venenatis leo sit amet sodales malesuada. Morbi quis convallis lorem, quis malesuada elit. Integer suscipit mauris et ex finibus, id aliquam nisi maximus. Quisque lacinia suscipit ipsum, in posuere elit eleifend vel. Vestibulum vehicula, est ac interdum tristique, elit odio volutpat ex, eu eleifend erat dolor a mauris.\nInterdum et malesuada fames ac ante ipsum primis in faucibus. Nunc sagittis sagittis orci, a mollis justo ultrices id. Vestibulum a neque eget magna ultricies posuere eget ut sem. Nunc egestas vestibulum metus. Praesent et mi quis dolor pellentesque mattis quis eu turpis. Nunc convallis quis elit vitae ornare. Sed venenatis sed lorem eget posuere. Nam lobortis diam dui, et sollicitudin velit faucibus quis. Donec sit amet neque non diam aliquam imperdiet.\n";}
        int imgRes = in.getIntExtra("eimg",0);

        setTitle(title);
        judul.setText(title);
        Detail.setText(description);
        gambar.setImageResource(imgRes);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahIsi();
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kurangIsi();
            }
        });
    }


    public void tambahIsi(){
        status();
        if (progress.getDrawable().getLevel() + 1 <=6) {
            //volume air akan ditambah sebanyak 1 liter
            level=level+1;
            //set text view dengan ukuran yang sudah dihitung
            Stats.setText(level + "L");
            //maka set image battery dengan battery satu tingkat sebelum level tertinggi
            progress.setImageLevel(progress.getDrawable().getLevel() + 1);
        } else {
            //apabila level battery penuh
            progress.setImageLevel(6);
            //maka akan muncul toast yang memberi tahu bahwa air sudah penuh
            Toast.makeText(this, "Full!", Toast.LENGTH_LONG).show();
        }
    }

    public void kurangIsi(){
        status();
        if (progress.getDrawable().getLevel() - 1 >= 1) {
            //volume air akan dikurangi sebanyak 1 Liter
            level=level-1;
            //set text view dengan ukuran yang sudah dihitung
            Stats.setText(level + "L");
            //maka set image battery dengan battery satu tingkat sebelum level terendah
            progress.setImageLevel(progress.getDrawable().getLevel() - 1);
        } else {
            //apabila battery dikurangi sampai level paling rendah
            progress.setImageLevel(0);
            //maka akan muncul toast yang memberi tahu bahwa air hampir habis
            Toast.makeText(this, "Almost empty!", Toast.LENGTH_LONG).show();
        }
    }

    public void status(){
        Stats.setText(""+level+"L");
    }
}
