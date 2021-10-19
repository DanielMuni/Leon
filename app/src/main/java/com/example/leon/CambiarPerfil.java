package com.example.leon;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CambiarPerfil extends AppCompatActivity {
    String imageSrc;
    DataBase usuarios = MainActivity.usuarios;
    Usuario usuarioActual;
    ImageView imagenSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_perfil);

        imagenSelecionada = findViewById(R.id.imagenSelecionada);
        usuarioActual = usuarios.findUsuarioSeleccionado();
    }

    @Override
    protected void onStart() {
        super.onStart();
        usarPerfilActual();
    }

    public void perfil1(View v){
        imageSrc = "perfil_1";
        imagenSelecionada.setImageResource(R.drawable.perfil_1);
    }

    public void perfil2(View v){
        imageSrc = "perfil_2";
        imagenSelecionada.setImageResource(R.drawable.perfil_2);
    }

    public void perfil3(View v){
        imageSrc = "perfil_3";
        imagenSelecionada.setImageResource(R.drawable.perfil_3);
    }

    public void perfil4(View v){
        imageSrc = "perfil_4";
        imagenSelecionada.setImageResource(R.drawable.perfil_4);
    }

    private void usarPerfilActual(){
        int imageResource = getApplicationContext().getResources().getIdentifier("drawable/" + usuarioActual.getImagenSrc(), null, getApplicationContext().getPackageName());
        imagenSelecionada.setImageResource(imageResource);
        imageSrc = usuarioActual.getImagenSrc();
    }

    public void eliminarCambios(View v){
        usarPerfilActual();
    }

    public void guardar(View v){
        if (imageSrc != usuarioActual.getImagenSrc() ) {
            try{
                usuarioActual.setImagen(imageSrc);
                usuarios.actualizarImgSrc(usuarioActual);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        finish();
    }
}