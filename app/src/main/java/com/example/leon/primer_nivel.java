package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class primer_nivel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer_nivel);
    }

    // Funcion Silueta Correcta
    public void SiluetaCorrectaNvl1(View view){
        Toast.makeText(this, "¡Silueta Correcta!\"", Toast.LENGTH_LONG).show();
        Intent nivelDos = new Intent(this, segundo_nivel.class);
        startActivity(nivelDos);
    }


}
