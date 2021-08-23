package com.example.muhamad_nurohman_205411180;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class profil extends AppCompatActivity {
    Button tombol;
    Intent pindah2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menampilkan profil.xml
        setContentView(R.layout.profil);

        tombol = (Button) findViewById(R.id.depan);
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kode untuk pindah ke activity lain
                pindah2 = new Intent(com.example.muhamad_nurohman_205411180.profil.this, MainActivity.class);
                startActivity(pindah2);
                finish();

            }
        });

    }


}