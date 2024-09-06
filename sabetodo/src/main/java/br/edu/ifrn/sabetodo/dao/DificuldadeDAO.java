package br.edu.ifrn.sabetodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sabetodo.dominio.Dificuldade;

public class DificuldadeDAO{

	public List<Dificuldade> buscarDificuldades() {

		List<Dificuldade> dificuldades = new ArrayList<Dificuldade>();

		String query = "SELECT nome, questao_id, pontuacao_roleta FROM dificuldade;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			ResultSet resultSet = comando.executeQuery();

			while (resultSet.next()) {

				Dificuldade dificuldade = new Dificuldade();
				dificuldade.setNome(resultSet.getString("nome"));
				dificuldade.setQuestaoId(resultSet.getInt("questao_id"));
				dificuldade.setPontuacaoRoleta(resultSet.getInt("pontuacao_roleta"));

				dificuldades.add(dificuldade);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}

		return dificuldades;

	}






}