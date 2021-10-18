package com.example.leon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "usuarios.db";

    private static final String TABLE = "usuarios";
    private static final String COLUMN_ID = "usuarioid";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_PUNTUACION = "puntuacion";
    private static final String COLUMN_IMAGEN = "imagen";
    private static final String COLUMN_STATUS = "status";

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " +
                TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,  " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_PUNTUACION + " INTEGER, " +
                COLUMN_IMAGEN + " TEXT, " +
                COLUMN_STATUS +" INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void addUsuario(String nombre, String imagenSrc){
        SQLiteDatabase db = this.getWritableDatabase();

        //Quitamos el usuario anteriormente selecionado
        String count = "SELECT count(*) FROM " + TABLE;
        Cursor cursor = db.rawQuery(count, null);
        cursor.moveToFirst();
        int icount = cursor.getInt(0);
        if (icount > 0) {
            ContentValues query = new ContentValues();
            query.put(COLUMN_STATUS, 0);
            db.update(TABLE, query, COLUMN_STATUS + " = 1", null);
        }

        //Agregamos el nuevo usuario como seleccionado
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, nombre);
        values.put(COLUMN_PUNTUACION, 0);
        values.put(COLUMN_IMAGEN, imagenSrc);
        values.put(COLUMN_STATUS, 1);
        db.insert(TABLE, null, values);
        db.close();
    }

    public Usuario findUsuarioSeleccionado(){
        SQLiteDatabase db = this.getWritableDatabase();
        Usuario usuario = null;

        String count = "SELECT count(*) FROM " + TABLE;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0 ) {
            String query = "SELECT * FROM " + TABLE + " WHERE " + COLUMN_STATUS + " = 1";
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst())
                usuario = new Usuario(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3));
            cursor.close();
        }

        db.close();
        return usuario;
    }

    public void iniciarSesionByIndex(int index){
        SQLiteDatabase db = this.getWritableDatabase();
        Usuario usuario = null;

        String count = "SELECT count(*) FROM " + TABLE;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) {
            ContentValues query = new ContentValues();
            query.put(COLUMN_STATUS, 0);
            db.update(TABLE, query, COLUMN_STATUS + " = 1", null);

            String busqueda = "SELECT * FROM " + TABLE;
            Cursor cursor = db.rawQuery(busqueda, null);
            int id;
            while (index > -1) {
                cursor.moveToNext();
                index--;
            }
            id = cursor.getInt(0);
            cursor.close();

            ContentValues activar = new ContentValues();
            activar.put(COLUMN_STATUS, 1);
            db.update(TABLE, activar, COLUMN_ID + " = " + id, null);
        }

        db.close();
    }

    public void actualizarPuntos(Usuario usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues query = new ContentValues();
        query.put(COLUMN_PUNTUACION, usuario.getPuntuacion());
        db.update(TABLE, query, COLUMN_ID + " = " + usuario.getId(), null);
        db.close();
    }
    public void limpiar(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE;
        db.execSQL(query);
        db.close();
    }

    public ArrayList<Usuario> getUsuariosRegistrados(){
        ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext())
            usuariosRegistrados.add(new Usuario (cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));

        cursor.close();
        db.close();

        return usuariosRegistrados;
    }

    public ArrayList<String> getUsuariosRegistradosSimple(){
        ArrayList<String> usuariosRegistrados = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            usuariosRegistrados.add(cursor.getString(1) );
        }
        cursor.close();
        db.close();

        return usuariosRegistrados;
    }
}
