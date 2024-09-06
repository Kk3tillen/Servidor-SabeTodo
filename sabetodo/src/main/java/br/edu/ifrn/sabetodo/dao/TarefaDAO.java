package br.edu.ifrn.sabetodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sabetodo.dominio.Tarefa;

public class TarefaDAO {

public List<Tarefa> buscarTarefas() {
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		String query = "SELECT id, nome, qnt_giros_roleta, emblema_id FROM tarefa where roleta = 0";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);
			

			ResultSet resultSet = comando.executeQuery();
			
			while (resultSet.next()) {
				
				Tarefa tarefa = new Tarefa();
				tarefa.setId(resultSet.getInt("id"));
				tarefa.setNome(resultSet.getString("nome"));
				tarefa.setQntGirosRoleta(resultSet.getInt("qnt_giros_roleta"));
				tarefa.setIdEmblema(resultSet.getInt("emblema_id"));
				
				tarefas.add(tarefa);
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
		
		return tarefas;
		
	}
	
	public List<Tarefa> buscarTarefas(String email) {
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		String query = "SELECT tarefa.id as id_tarefa, tarefa.nome as nome_tarefa, tarefa.qnt_giros_roleta, emblema_id, esta_na_tarefa, progresso FROM tarefa inner join estudante_tarefa on (tarefa.id = estudante_tarefa.tarefa_id) \n"
				+ "inner join estudante on (estudante_tarefa.estudante_email = estudante.email)\n"
				+ "where estudante.email = ? and tarefa.roleta = 0" ;

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setString(1, email);

			ResultSet resultSet = comando.executeQuery();
			
			while (resultSet.next()) {
				
				Tarefa tarefa = new Tarefa();
				tarefa.setId(resultSet.getInt("id_tarefa"));
				tarefa.setNome(resultSet.getString("nome_tarefa"));
				tarefa.setQntGirosRoleta(resultSet.getInt("qnt_giros_roleta"));
				tarefa.setIdEmblema(resultSet.getInt("emblema_id"));
				tarefa.setEstaNaTarefa(resultSet.getBoolean("esta_na_tarefa"));
				tarefa.setProgresso(resultSet.getInt("progresso"));
				
				tarefas.add(tarefa);
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
		
		return tarefas;
		
	}
	
}
