package com.example.muhamad_nurohman_205411180;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pesanan;
    Button profil;
    Intent pindah_pesanan;
    Intent pindah_profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Mengarahkan tampilan pertama yang dijalankan ketika program dijalankan adalah menuju ke file layout->activity_main
        setContentView(R.layout.activity_main);

        pesanan = (Button) findViewById(R.id.button);

        profil = (Button) findViewById(R.id.button2);

        pesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kode untuk pindah ke activity lain
                pindah_pesanan = new Intent(getApplicationContext(),pesanan.class);
                startActivity(pindah_pesanan);
                finish();
            }
        });

        //digunakan untuk perintah button setelah di klik menuju ke profil
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kode untuk pindah ke activity lain
                pindah_profil = new Intent(getApplicationContext(), profil.class);
                startActivity(pindah_profil);
                finish();
            }
        });


    }
}