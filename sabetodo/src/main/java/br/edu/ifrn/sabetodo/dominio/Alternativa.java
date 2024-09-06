package br.edu.ifrn.sabetodo.dominio;

public class Alternativa {
	 
	private int id, questaoId;
	private String descricao;
	private int correta;
	
	public Alternativa() {
		
	}
	

	public Alternativa(int id, int questaoId, String descricao, int correta) {
		
		this.id = id;
		this.questaoId = questaoId;
		this.descricao = descricao;
		this.correta = correta;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestaoId() {
		return questaoId;
	}

	public void setQuestaoId(int questaoId) {
		this.questaoId = questaoId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCorreta() {
		return correta;
	}

	public void setCorreta(int correta) {
		this.correta = correta;
	}
	
	
	
}
