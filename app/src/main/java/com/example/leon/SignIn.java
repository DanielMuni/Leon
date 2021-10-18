package com.example.leon;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {
    EditText nombre;
    String imageSrc;
    DataBase usuarios = MainActivity.usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        //nombre = findViewById(R.id.nombreDeUsuario);
        imageSrc = "perfil_0";
    }

    public void perfil1(View v){
        imageSrc = "perfil_1";
    }

    public void perfil2(View v){
        imageSrc = "perfil_2";
    }

    public void perfil3(View v){
        imageSrc = "perfil_3";
    }

    public void perfil4(View v){
        imageSrc = "perfil_4";
    }

    public void crear(View v){
        String nombreUsuario = nombre.getText().toString();
        if (imageSrc != "perfil_0" && nombreUsuario != "") {
            try{
                usuarios.addUsuario(nombreUsuario, imageSrc);
                Intent intent = new Intent(this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}