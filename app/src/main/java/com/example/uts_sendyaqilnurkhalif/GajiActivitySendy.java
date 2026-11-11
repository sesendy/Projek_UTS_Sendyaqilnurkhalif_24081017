
package com.example.uts_sendyaqilnurkhalif;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class GajiActivitySendy extends Activity {

    EditText edtNIK, edtNama, edtGajiPokok;
    EditText edtTunjanganJabatan, edtHariKerja;

    TextView txtMakan, txtTransport;
    TextView txtGajiKotor, txtPajak, txtGajiBersih;

    Button btnHitung, btnKembali;

    NumberFormat rupiah = NumberFormat.getCurrencyInstance(
            new Locale("id", "ID")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_sendy);

        edtNIK = findViewById(R.id.edtNIK);
        edtNama = findViewById(R.id.edtNama);
        edtGajiPokok = findViewById(R.id.edtGajiPokok);
        edtTunjanganJabatan = findViewById(R.id.edtTunjanganJabatan);
        edtHariKerja = findViewById(R.id.edtHariKerja);

        txtMakan = findViewById(R.id.txtMakan);
        txtTransport = findViewById(R.id.txtTransport);
        txtGajiKotor = findViewById(R.id.txtGajiKotor);
        txtPajak = findViewById(R.id.txtPajak);
        txtGajiBersih = findViewById(R.id.txtGajiBersih);

        btnHitung = findViewById(R.id.btnHitung);
        btnKembali = findViewById(R.id.btnKembali);

        btnHitung.setOnClickListener(v -> hitungGaji());

        btnKembali.setOnClickListener(v -> finish());
    }

    private void hitungGaji() {

        String nik = edtNIK.getText().toString().trim();
        String nama = edtNama.getText().toString().trim();
        String gaji = edtGajiPokok.getText().toString().trim();
        String jabatan = edtTunjanganJabatan.getText().toString().trim();
        String hari = edtHariKerja.getText().toString().trim();

        if (nik.isEmpty() || nama.isEmpty() ||
                gaji.isEmpty() || jabatan.isEmpty() ||
                hari.isEmpty()) {

            Toast.makeText(this,
                    "Semua data harus diisi!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double gajiPokok = Double.parseDouble(gaji);
            double tunjanganJabatan = Double.parseDouble(jabatan);
            int jumlahHari = Integer.parseInt(hari);

            if (gajiPokok < 0 || tunjanganJabatan < 0 ||
                    jumlahHari < 0) {
                Toast.makeText(this,
                        "Masukkan angka yang tidak negatif!",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            double tunjanganMakan = jumlahHari * 10000;
            double tunjanganTransport = jumlahHari * 5000;

            double gajiKotor = gajiPokok +
                    tunjanganJabatan +
                    tunjanganMakan +
                    tunjanganTransport;

            double pajak = gajiKotor * 0.10;

            double gajiBersih = gajiKotor - pajak;

            txtMakan.setText(rupiah.format(tunjanganMakan));
            txtTransport.setText(rupiah.format(tunjanganTransport));
            txtGajiKotor.setText(rupiah.format(gajiKotor));
            txtPajak.setText(rupiah.format(pajak));
            txtGajiBersih.setText(rupiah.format(gajiBersih));

        } catch (NumberFormatException e) {
            Toast.makeText(this,
                    "Masukkan angka dengan format yang benar!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
