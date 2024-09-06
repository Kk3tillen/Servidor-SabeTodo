package br.edu.ifrn.sabetodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifrn.sabetodo.dominio.Estudante;


public class EstudanteDAO {

	public List<Estudante> buscarAlunos() {
			
			List<Estudante> estudantes = new ArrayList<Estudante>();
			
			String query = "SELECT email, nome, biografia, data_cadastro, senha, qnt_giros_roleta, pontuacao, ultima_atualizacao_perfil, img_perfil FROM aluno;";

			Connection conexao = Conexao.conectar();

			try {

				PreparedStatement comando = conexao.prepareStatement(query);

				ResultSet resultSet = comando.executeQuery();
				
				while (resultSet.next()) {
					
					Estudante estudante = new Estudante();
					estudante.setEmail(resultSet.getString("email"));
					estudante.setNome(resultSet.getString("nome"));
					estudante.setBiografia(resultSet.getString("biografia"));
					estudante.setDataCadastro(resultSet.getDate("data_cadastro").getTime());
					estudante.setSenha(resultSet.getString("senha"));
					estudante.setQntGirosRoleta(resultSet.getInt("qnt_giros_roleta"));
					estudante.setPontuacao(resultSet.getInt("pontuacao"));
					estudante.setUltimaAtualizacaoPerfil(resultSet.getDate("ultima_atualizacao_perfil").getTime());
					estudante.setImgPerfil(resultSet.getInt("img_perfil"));
					
					estudantes.add(estudante);
					
				}
				
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}

			finally {
				Conexao.desconectar();
			}
			
			return estudantes;
			
		}
	
	public List<Estudante> buscarRanking() {
		
		List<Estudante> estudantes = new ArrayList<Estudante>();
		
		String query = "SELECT nome, img_perfil, pontuacao FROM sabetodo_bd.estudante order by pontuacao desc;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			ResultSet resultSet = comando.executeQuery();
			
			while (resultSet.next()) {
				
				Estudante estudante = new Estudante();
				
				estudante.setNome(resultSet.getString("nome"));
				estudante.setPontuacao(resultSet.getInt("pontuacao"));
				estudante.setImgPerfil(resultSet.getInt("img_perfil"));
			
				estudantes.add(estudante);
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
		
		return estudantes;
		
	}

	public void inserirAluno(Estudante aluno) {

		String query = "INSERT INTO aluno(email, nome, senha, img_perfil) VALUES(?,?,?,?);";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setString(1, aluno.getEmail());
			comando.setString(2, aluno.getNome());
			comando.setString(3, aluno.getSenha());
			comando.setInt(4, aluno.getImgPerfil());

			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Aluno(a) inserido(a) com sucesso!");
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
	}

	public void alterarAluno(Estudante aluno) {

		String query = "UPDATE pontuacao = ?, nome = ?, email = ? senha = ?  img_perfil = ?  biografia = ? ultima_atualizacao_perfil = ?;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setInt(1, aluno.getPontuacao());
			comando.setString(2, aluno.getNome());
			comando.setString(3, aluno.getEmail());
			comando.setString(4, aluno.getSenha());
			comando.setInt(5, aluno.getImgPerfil());
			comando.setString(6, aluno.getBiografia());
			comando.setLong(7, aluno.getUltimaAtualizacaoPerfil());

			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Aluno atualizada com sucesso!");
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
	}

	public void removerAluno(String email, String nome, String senha) {
		String query = "DELETE from aluno where email = ?, nome = ?, senha = ?;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setString(1, email);
			comando.setString(2, nome);
			comando.setString(3, senha);

			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Aluno removida com sucesso!");
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
	}
}