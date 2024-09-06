package br.edu.ifrn.sabetodo.dominio;

public class Tarefa {

	private int id;
    private String nome;
    private int qntGirosRoleta;
    private int idEmblema;
    private boolean concluida;
    private boolean estaNaTarefa;
    private int progresso;
    
    public Tarefa() {
    	
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

	public int getQntGirosRoleta() {
		return qntGirosRoleta;
	}

	public void setQntGirosRoleta(int qntGirosRoleta) {
		this.qntGirosRoleta = qntGirosRoleta;
	}

	public int getIdEmblema() {
		return idEmblema;
	}

	public void setIdEmblema(int idEmblema) {
		this.idEmblema = idEmblema;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
	
	public void setEstaNaTarefa(boolean estaNaTarefa) {
		this.estaNaTarefa = estaNaTarefa;
	}
	public boolean getEstaNaTarefa() {
		return estaNaTarefa;
	}

	public int getProgresso() {
		return progresso;
	}
	public void setProgresso(int progresso) {
		this.progresso = progresso;
	}
}
