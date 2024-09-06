package br.edu.ifrn.sabetodo.dominio;


public class Estudante {

    private String email;
    private String senha;
    private String nome;
    private String biografia;
    private long dataCadastro;
    private long ultimaAtualizacaoPerfil;
    private int imgPerfil;
    private int pontuacao;
    private int qntGirosRoleta;
    
    
    public Estudante(){
        
    }

	  public Estudante(String email, String senha, String nome, String biografia, long dataCadastro,
		long ultimaAtualizacaoPerfil, int imgPerfil, int pontuacao, int qntGirosRoleta) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.biografia = biografia;
		this.dataCadastro = dataCadastro;
		this.ultimaAtualizacaoPerfil = ultimaAtualizacaoPerfil;
		this.imgPerfil = imgPerfil;
		this.pontuacao = pontuacao;
		this.qntGirosRoleta = qntGirosRoleta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public long getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(long dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public long getUltimaAtualizacaoPerfil() {
		return ultimaAtualizacaoPerfil;
	}

	public void setUltimaAtualizacaoPerfil(long ultimaAtualizacaoPerfil) {
		this.ultimaAtualizacaoPerfil = ultimaAtualizacaoPerfil;
	}

	public int getImgPerfil() {
		return imgPerfil;
	}

	public void setImgPerfil(int imgPerfil) {
		this.imgPerfil = imgPerfil;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getQntGirosRoleta() {
		return qntGirosRoleta;
	}

	public void setQntGirosRoleta(int qntGirosRoleta) {
		this.qntGirosRoleta = qntGirosRoleta;
	}

}
