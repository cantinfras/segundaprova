package com.example.elton.segundaprova;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends ListActivity   {
    private final String BASE_URL = "https://provaddm2018.000webhostapp.com/lista_de_alunos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chamada();
    }

    private AlunoAdapter getRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()).create(AlunoAdapter.class);
    }

    private void chamada() {
        Call<List<Post>> call = getRetrofit().obterPost();
        call.enqueue(new Callback<List<Post>>() {//chamada assíncrona
            public void onResponse(Call<List<Post>> call,
                                   Response<List<Post>> response) {
                int statusCode = response.code();
                List<Post> posts = response.body();
                setListAdapter(new Aluno(MainActivity.this, posts));
            }

            public void onFailure(Call<List<Post>> call, Throwable t) {
                // Log error here since request failed
                Log.i("teste", t.toString());
            }
        });
    }

}
