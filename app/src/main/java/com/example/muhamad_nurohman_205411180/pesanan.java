package com.example.muhamad_nurohman_205411180;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pesanan extends AppCompatActivity {
    Button tombol;
    Intent pindah;
    private EditText edtidpembeli,edtnamamakanan,edtjumlahbeli,edtharga,edtuangbayar;
    private Button btnproses;
    private Button btnreset;
    private TextView txtnamamakanan;
    private TextView txttotalbelanja;
    private TextView txtdiskon;
    private TextView txttotalakhir;
    private TextView txtuangkembali;
    private TextView txtbonus;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menampilkan pesanan.xml
        setContentView(R.layout.pesanan);

        edtidpembeli = (EditText) findViewById(R.id.edtidpembeli);
        edtnamamakanan = (EditText) findViewById(R.id.edtnamamakanan);
        edtjumlahbeli = (EditText) findViewById(R.id.edtjumlahbeli);
        edtharga = (EditText) findViewById(R.id.edtharga);
        edtuangbayar = (EditText) findViewById(R.id.edtuangbayar);
        btnproses = (Button) findViewById(R.id.btnproses);
        btnreset = (Button) findViewById(R.id.btnreset);
        txtnamamakanan = (TextView) findViewById(R.id.txtnamamakanan);
        txttotalbelanja = (TextView) findViewById(R.id.txttotalbelanja);
        txtdiskon = (TextView) findViewById(R.id.txtdiskon);
        txttotalakhir = (TextView) findViewById(R.id.txttotalakhir);
        txtuangkembali = (TextView) findViewById(R.id.txtuangkembali);
        txtbonus = (TextView) findViewById(R.id.txtbonus);
        txtketerangan = (TextView) findViewById(R.id.txtketerangan);

        tombol = (Button) findViewById(R.id.btnkeluar);
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kode untuk pindah ke activity lain
                pindah = new Intent(com.example.muhamad_nurohman_205411180.pesanan.this, MainActivity.class);
                startActivity(pindah);
                finish();

            }
        });

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String -> Double

                String namamakanan = edtnamamakanan.getText().toString().trim();
                String jumlahbeli = edtjumlahbeli.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String uangbayar = edtuangbayar.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja Anda : Rp "+ total);
                txtnamamakanan.setText("Nama Makanan Anda : "+ namamakanan);

                double diskon = (0.10*total);
                txtdiskon.setText("Diskon Anda : "+ diskon);

                double totalakhir = (total - diskon);
                txttotalakhir.setText("Total Akhir Anda : Rp "+totalakhir);

                //Pemberian Nilai If

                if (totalakhir >= 100000) {
                    txtbonus.setText("Bonus Anda : Ayam Geprek");
                }else if (totalakhir >= 50000) {
                    txtbonus.setText("Bonus Anda : Es Jeruk ");
                }else if (totalakhir >= 25000) {
                    txtbonus.setText("Bonus Anda : Es Teh");
                }else if (totalakhir >= 10000) {
                    txtbonus.setText("Bonus Anda : Sabun Mandi");
                }else{
                    txtbonus.setText("Bonus Anda : Tidak Ada bonus");
                }

                double uangkembali = (ub - total);
                txtuangkembali.setText("Uang Kembali Anda : Rp "+ uangkembali);


                if (ub < total) {
                    txtuangkembali.setText("Uang Kembali Anda : Rp0");
                    txtketerangan.setText("Keterangan : Uang Anda Kurang : Rp "+ (- uangkembali));
                }else{
                    txtketerangan.setText("Keterangan : Tunggu Kembalian");
                    txtuangkembali.setText("Uang Kembali Anda : Rp"+ uangkembali);
                }
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtidpembeli.setText(" ");
                edtnamamakanan.setText(" ");
                edtjumlahbeli.setText(" ");
                edtharga.setText(" ");
                edtuangbayar.setText(" ");
                txtnamamakanan.setText("Nama Makanan : -");
                txttotalbelanja.setText("Total belanja : Rp.0");
                txtdiskon.setText("Diskon : -");
                txttotalakhir.setText("Total Akhir : Rp.0");
                txtuangkembali.setText("Uang Kembali : Rp.0");
                txtbonus.setText("Bonus : -");
                txtketerangan.setText("Keterangan : -");

                Toast.makeText(getApplicationContext(), "Data Berhasil Di Hapus", Toast.LENGTH_LONG).show();

            }
        });

    }

}

