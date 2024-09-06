/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrn.sabetodo.dominio;

/**
 *
 * @author ferna
 */
public class Dificuldade {
    private String nome;
    private int questaoId;
    private int pontuacaoRoleta;

    public Dificuldade() {
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuestaoId() {
		return questaoId;
	}

	public void setQuestaoId(int questaoId) {
		this.questaoId = questaoId;
	}

	public int getPontuacaoRoleta() {
		return pontuacaoRoleta;
	}

	public void setPontuacaoRoleta(int pontuacaoRoleta) {
		this.pontuacaoRoleta = pontuacaoRoleta;
	}

}
