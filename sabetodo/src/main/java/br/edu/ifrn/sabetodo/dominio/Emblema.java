package br.edu.ifrn.sabetodo.dominio;

public class Emblema{

    private int id;
    private String nome;
    private int icon;
    private boolean conquistada;
    
    public Emblema() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
    
    public void setConquistada(boolean conquistada) {
    	this.conquistada = conquistada;
    }
  
    public boolean isConquistada() {
    	return conquistada;
    }
    
}