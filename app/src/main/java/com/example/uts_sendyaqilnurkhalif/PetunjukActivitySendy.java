
package com.example.uts_sendyaqilnurkhalif;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class PetunjukActivitySendy extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_sendy);

        Button btnKembali = findViewById(R.id.btnKembali);

        btnKembali.setOnClickListener(v -> finish());
    }
}
