package com.example.elton.segundaprova;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Aluno extends BaseAdapter {

    Context contexto;
    List<Post> lista;

    public Aluno(Context contexto, List<Post> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linha = LayoutInflater.from(contexto).inflate(R.layout.lista_alunos, null);
        Post post = lista.get(position);

        ImageView circulo = (ImageView) linha.findViewById(R.id.imageView);
        TextView nome = (TextView) linha.findViewById(R.id.textView);
        TextView nota = (TextView) linha.findViewById(R.id.textView2);


        circulo.findViewById(R.id.imageView);
        nome.setText("Nome: " + post.getNome());
        nota.setText("Nota: " + post.getNota());
        return linha;
    }
}
