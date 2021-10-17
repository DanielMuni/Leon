package com.example.leon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity_fallo extends AppCompatActivity implements OnLoadListener{
    ListView listView;
    ArrayList<String> usuarios;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.usuariosRegistrados);
        usuarios = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }

    @Override
    public void onLoadFinished(ArrayList<String> array) {
        usuarios = array;
        adapter.clear();
        adapter.addAll(usuarios);
        adapter.notifyDataSetChanged();
    }

    private static class LoadManager extends AsyncTask<String, Void, String>{
        private OnLoadListener listener;
        public LoadManager(OnLoadListener listener){
            this.listener = listener;
        }

        public void loadTodos(View v){
            LoadManager manager = new LoadManager(this);
            manager.onPostExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder sb = new StringBuilder();
            try{
                URL url = new URL(strings[0]);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return sb.toString();
        }

        @Override
        protected void onPostExecute(String result){
            ArrayList<String> array = new ArrayList<>();
            try {
                JSONArray json = new JSONArray(result);
                for (int i= 0; i < json.length(); i++){
                    JSONObject todo = json.getJSONObject(i);
                    array.add(todo.getString("title"));
                }
                listener.onLoadFinished(array);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void openMenuPrincipal(View v) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}