/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrn.sabetodo.dominio;

/**
 *
 * @author kezia
 */
public class Conteudo {

	private int id;
	private String titulo;
	private String somFrases;
	private int tarefaId;

	public Conteudo (){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSomFrases() {
		return somFrases;
	}

	public void setSomFrases(String somFrases) {
		this.somFrases = somFrases;
	}

	public int getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(int tarefaId) {
		this.tarefaId = tarefaId;
	}



}


