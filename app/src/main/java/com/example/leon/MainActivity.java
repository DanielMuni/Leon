package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    DataBase usuarios;
    ListView usuariosAElegir;
    ArrayAdapter<String> adapter;

    Usuario sesion;
    ImageView sesionImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuariosAElegir = findViewById(R.id.usuariosRegistrados);
        sesionImg = findViewById(R.id.imgUsuarioSelecionado);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        usuarios = new DataBase(this, null, null, 1);
        if (usuarios != null)
            System.out.println("?");
        //getApplicationContext() .deleteDatabase("usuarios.db");
    }


    @Override
    protected void onStart() {
        super.onStart();

        /*
        usuarios.limpiar();
        usuarios.addUsuario("Fer", "ardilla");
        usuarios.addUsuario("Lau", "ballenita");
        */
        //Actualizar sesion
        sesion = usuarios.findUsuarioSeleccionado();

        //Poner los usuarios en la lista
        adapter.addAll(usuarios.getUsuariosRegistradosSimple());
        usuariosAElegir.setAdapter(adapter);

        //Poner la imagen de perfil de usuario activo
        int imageResource = getApplicationContext().getResources().getIdentifier("drawable/" + sesion.getImagenSrc(), null, getApplicationContext().getPackageName());
        sesionImg.setImageResource(imageResource);
    }

    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }



}