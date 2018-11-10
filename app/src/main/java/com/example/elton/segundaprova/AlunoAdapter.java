package com.example.elton.segundaprova;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface AlunoAdapter {
    @GET("posts")
    Call<List<Post>> obterPost();
}
