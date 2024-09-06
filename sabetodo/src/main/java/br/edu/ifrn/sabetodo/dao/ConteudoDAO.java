/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrn.sabetodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sabetodo.dominio.Conteudo;

public class ConteudoDAO {
	public List<Conteudo> buscarConteudos() {

		List<Conteudo> conteudos = new ArrayList<Conteudo>();

		String query = "SELECT id, titulo, som_frases, tarefa_id FROM conteudo";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			ResultSet resultSet = comando.executeQuery();

			while (resultSet.next()) {

				Conteudo conteudo = new Conteudo();

				conteudo.setId(resultSet.getInt("id"));
				conteudo.setTitulo(resultSet.getString("titulo"));
				conteudo.setSomFrases(resultSet.getString("som_frases"));
				conteudo.setTarefaId(resultSet.getInt("data_cadastro"));


				conteudos.add(conteudo);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}

		return conteudos;

	}



	public void inserirConteudo(Conteudo conteudo) {

		String query = "INSERT INTO conteudo(id, titulo, som_frases, tarefa_id);";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setInt(1, conteudo.getId());
			comando.setString(2, conteudo.getTitulo());
			comando.setString(3, conteudo.getSomFrases());
			comando.setInt(4, conteudo.getTarefaId());

			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Conteúdos inseridos com sucesso!");
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
	}



	public void alterarConteudo(Conteudo conteudo) {

		String query = "UPDATE id = ?, titulo = ?, som_frases = ?, tarefa_id = ?;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setInt(1, conteudo.getId());
			comando.setString(2, conteudo.getTitulo());
			comando.setString(3, conteudo.getSomFrases());
			comando.setInt(4, conteudo.getTarefaId());


			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Conteúdo atualizado com sucesso!");
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
	}

	public void removerConteudo(int id, String titulo, String som_frases, int tarefas_id) {
		String query = "DELETE from conteudo where id = ?, titulo = ?, som_frases = ?, tarefas_id = ?;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setInt(1, id);
			comando.setString(2, titulo);
			comando.setString(3, som_frases);
			comando.setInt(4, tarefas_id);

			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Conteúdo removido com sucesso!");
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}

	}



}


