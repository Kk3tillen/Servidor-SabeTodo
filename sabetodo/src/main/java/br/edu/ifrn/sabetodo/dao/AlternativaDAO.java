package br.edu.ifrn.sabetodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sabetodo.dominio.Alternativa;

public class AlternativaDAO {
	
	public List<Alternativa> buscarAlternativas(int idQuestao) {

		List<Alternativa> alternativas = new ArrayList<Alternativa>();

		String query = "SELECT id, descricao, correta, Questao_id FROM alternativas where Questao_id = ?";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setInt(1, idQuestao);
			
			System.out.println(comando);

			ResultSet resultSet = comando.executeQuery();

			while (resultSet.next()) {

				Alternativa alternativa = new Alternativa();

				alternativa.setId(resultSet.getInt("id"));
				alternativa.setDescricao(resultSet.getString("descricao"));
				alternativa.setCorreta(resultSet.getInt("correta"));
				alternativa.setQuestaoId(resultSet.getInt("Questao_id"));


				alternativas.add(alternativa);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}

		return alternativas;

	}
}
