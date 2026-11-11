
package com.example.uts_sendyaqilnurkhalif;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivitySendy extends Activity {

    Button btnGaji, btnPetunjuk, btnTentang, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sendy);

        btnGaji = findViewById(R.id.btnGaji);
        btnPetunjuk = findViewById(R.id.btnPetunjuk);
        btnTentang = findViewById(R.id.btnTentang);
        btnExit = findViewById(R.id.btnExit);

        btnGaji.setOnClickListener(v -> {
            startActivity(new Intent(
                    MainActivitySendy.this,
                    GajiActivitySendy.class
            ));
        });

        btnPetunjuk.setOnClickListener(v -> {
            startActivity(new Intent(
                    MainActivitySendy.this,
                    PetunjukActivitySendy.class
            ));
        });

        btnTentang.setOnClickListener(v -> {
            startActivity(new Intent(
                    MainActivitySendy.this,
                    TentangActivitySendy.class
            ));
        });

        btnExit.setOnClickListener(v -> finishAffinity());
    }
}
