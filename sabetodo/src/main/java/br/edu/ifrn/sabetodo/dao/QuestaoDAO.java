package br.edu.ifrn.sabetodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sabetodo.dominio.Alternativa;
import br.edu.ifrn.sabetodo.dominio.EstudanteTarefa;
import br.edu.ifrn.sabetodo.dominio.Questao;

public class QuestaoDAO {

	public List<Questao> buscarQuestoes(int idTarefa) {

		List<Questao> questoes = new ArrayList<Questao>();

		String query = "SELECT enunciado, pontuacao, id, audio, imagem, imagem2, enunciado2, enunciado3, ordem FROM questao where tarefa_id = ? order by ordem asc;";

		Connection conexao = Conexao.conectar();


		try {

			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setInt(1, idTarefa);

			ResultSet resultSet = comando.executeQuery();

			while (resultSet.next()) {

				Questao questao = new Questao();
				questao.setId(resultSet.getInt("id"));
				questao.setPontuacao(resultSet.getInt("pontuacao"));
				questao.setEnunciado(resultSet.getString("enunciado"));
				questao.setAudio(resultSet.getString("audio"));
				questao.setImagem(resultSet.getString("imagem"));
				questao.setImagem2(resultSet.getString("imagem2"));
				questao.setEnunciado2(resultSet.getString("enunciado2"));
				questao.setEnunciado3(resultSet.getString("enunciado3"));
				questao.setOrdem(resultSet.getInt("ordem"));


				questoes.add(questao);
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}

		return questoes;

	}

	public Questao questaoRoletaAleatoriaPorDificuldadeId(int dificuldadeId) {

		String query = "SELECT * FROM questao WHERE tarefa_id = (SELECT id FROM tarefa WHERE roleta = 1) AND id_dificuldade = ? ORDER BY rand() LIMIT 1;";

		Connection conexao = Conexao.conectar();

		Questao questao = new Questao();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setInt(1, dificuldadeId);

			ResultSet resultSet = comando.executeQuery(); 

			if (resultSet.next()) {

				questao.setId(resultSet.getInt("id"));
				questao.setEnunciado(resultSet.getString("enunciado"));
				questao.setPontuacao(resultSet.getInt("pontuacao"));

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}

		return questao;

	}

	public Questao buscarQuestao(int idTarefa, String email) {
		Questao questao = null;

		String query = "SELECT enunciado, pontuacao, id, audio, imagem, imagem2, enunciado2, enunciado3, ordem FROM questao where tarefa_id = ?"
				+ " and ordem = (select ordem from estudante_tarefa where estudante_email = ? and tarefa_id = ?);";

		Connection conexao = Conexao.conectar();


		try {

			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setInt(1, idTarefa);
			comando.setString(2, email);
			comando.setInt(3, idTarefa);



			ResultSet resultSet = comando.executeQuery();

			if (resultSet.next()) {

				questao = new Questao();
				questao.setId(resultSet.getInt("id"));
				questao.setPontuacao(resultSet.getInt("pontuacao"));
				questao.setEnunciado(resultSet.getString("enunciado"));
				questao.setAudio(resultSet.getString("audio"));
				questao.setImagem(resultSet.getString("imagem"));
				questao.setImagem2(resultSet.getString("imagem2"));
				questao.setEnunciado2(resultSet.getString("enunciado2"));
				questao.setEnunciado3(resultSet.getString("enunciado3"));
				questao.setOrdem(resultSet.getInt("ordem"));


			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}


		return questao;
	}
	
	public boolean registrar(EstudanteTarefa estudanteTarefa) {
		boolean resultado = false;
		
		String query = "UPDATE estudante_tarefa set ordem = ? where estudante_email = ? and tarefa_id = ?;"; 

		Connection conexao = Conexao.conectar();
		

		try {

			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setInt(1, estudanteTarefa.getOrdem() + 1);
			comando.setString(2, estudanteTarefa.getEmailEstudante());
			comando.setInt(3, estudanteTarefa.getIdTarefa());
			

			int linhasAfetadas = comando.executeUpdate();
			
			if (linhasAfetadas > 0) {
				
				resultado = true;
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
		
		
		return resultado;
	}
}