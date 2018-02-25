package com.deqode.android.zulkarnains_1202141255_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MenuUtama extends AppCompatActivity {

    EditText e1;//variable edittext
    EditText e2;//variable edittext
    Button b1;//variable button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        e1 = (EditText)findViewById(R.id.userName);//inisiasi edittext username dari xml
        e2 = (EditText)findViewById(R.id.password);//inisiasi edittext password dari xml
        b1 = (Button)findViewById(R.id.button);//inisiasi edittext button dari xml
    }

    public void logIn(View view) {

        String userName = e1.getText().toString();
        String passWord = e2.getText().toString();

        if(userName.equals("EAD") & passWord.equals("mobile")){//mengecek apabila username dan password sesuai dengan ketentuan
            Toast.makeText(MenuUtama.this, "Log IN Berhasil", Toast.LENGTH_SHORT).show();//menampilkan toast berhasil
            startActivity(new Intent(MenuUtama.this, DaftarAir.class));
        }else{
            Toast.makeText(MenuUtama.this, "Log IN Gagal", Toast.LENGTH_SHORT).show();//menampilkan toast gagal
        }
    }
}
