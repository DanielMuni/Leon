package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DataBase usuarios;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuarios = new DataBase(this, null, null, 1)
    }
        public void openMenuPrincipal(View v) {
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        }



}