/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class CategoriaINF {

    private String titulo;
    private ArrayList<FilmeINF> filmes = new ArrayList<FilmeINF>();

    public CategoriaINF(String titulo, ArrayList<FilmeINF> filmes) {
        this.titulo = titulo;
        this.filmes = filmes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<FilmeINF> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<FilmeINF> filmes) {
        this.filmes = filmes;
    }
}
