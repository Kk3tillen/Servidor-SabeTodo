package br.edu.ifrn.sabetodo.dominio;

public class EstudanteTarefa {

	private String emailEstudante;
	private int idTarefa;
	private int ordem;
	
	public EstudanteTarefa() {
		
	}
	public EstudanteTarefa(String emailEstudante, int idTarefa, int ordem) {
		
		this.emailEstudante = emailEstudante;
		this.idTarefa = idTarefa;
		this.ordem = ordem;
	}

	public String getEmailEstudante() {
		return emailEstudante;
	}


	public void setEmailEstudante(String emailEstudante) {
		this.emailEstudante = emailEstudante;
	}


	public int getIdTarefa() {
		return idTarefa;
	}


	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}


	public int getOrdem() {
		return ordem;
	}


	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	
}
