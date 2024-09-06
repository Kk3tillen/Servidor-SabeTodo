/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrn.sabetodo.dominio;

import java.util.ArrayList;
import java.util.List;

public class Questao {
    
    private String enunciado;
    private int pontuacao;
    private int id;
    private List<Alternativa> alternativas;
    private int ordem;
    private String audio;
    private String enunciado2;
    private String enunciado3;
    private String imagem;
    private String imagem2;
    
    public Questao(){
        alternativas = new ArrayList<>();
    }
    
    public Questao(String enunciado, int pontuacao, int id) {
        this.enunciado = enunciado;
        this.pontuacao = pontuacao;
        this.id = id;
        alternativas = new ArrayList<>();
    }

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getEnunciado2() {
		return enunciado2;
	}

	public void setEnunciado2(String enunciado2) {
		this.enunciado2 = enunciado2;
	}

	public String getImagem() {
		return imagem;
	}

	public String getEnunciado3() {
		return enunciado3;
	}

	public void setEnunciado3(String enunciado3) {
		this.enunciado3 = enunciado3;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
    public void setImagem2(String imagem2) {
		this.imagem2 = imagem2;
	}
    public String getImagem2() {
		return imagem2;
	}
	
	
}

   