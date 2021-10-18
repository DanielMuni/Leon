package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public static DataBase usuarios;
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

        usuariosAElegir.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int index = position;
                usuarios.iniciarSesionByIndex(index);
               openMenuPrincipal();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        //Actualizar sesion
        sesion = usuarios.findUsuarioSeleccionado();

        //Poner los usuarios en la lista
        adapter.clear();
        adapter.addAll(usuarios.getUsuariosRegistradosSimple());
        usuariosAElegir.setAdapter(adapter);

        //Poner la imagen de perfil de usuario activo
        if (sesion != null) {
            int imageResource = getApplicationContext().getResources().getIdentifier("drawable/" + sesion.getImagenSrc(), null, getApplicationContext().getPackageName());
            sesionImg.setImageResource(imageResource);
        }
        else
            sesionImg.setImageResource(R.drawable.perfil_0);
    }


    public void openMenuPrincipal() {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }

    public void crear(View v) {
        try {
            Intent intent = new Intent(this, SignIn.class);
            startActivity(intent);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}