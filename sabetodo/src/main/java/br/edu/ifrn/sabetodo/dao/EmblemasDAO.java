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

import br.edu.ifrn.sabetodo.dominio.Emblema;

public class EmblemasDAO {
    
    public List<Emblema> buscarEmblemas() {
		
		List<Emblema> emblemas = new ArrayList<Emblema>();
		
		String query = "SELECT id, nome, icon FROM emblema;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			ResultSet resultSet = comando.executeQuery();
			
			while (resultSet.next()) {
				
				Emblema emblema = new Emblema();
				emblema.setId(resultSet.getInt("id"));
				emblema.setNome(resultSet.getString("nome"));
				emblema.setIcon(resultSet.getInt("icon"));
				
				
				emblemas.add(emblema);
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
		
		return emblemas;
		
	}
public List<Emblema> buscarEmblemas(String email) {
		
		List<Emblema> emblemas = new ArrayList<Emblema>();
		
		String query = "SELECT emblema.id as id_emblema, emblema.nome as nome_emblema, emblema.icon FROM emblema inner join estudante_emblema on (emblema.id = estudante_emblema.emblema_id)\n"
				+ "inner join estudante on (estudante_emblema.estudante_email = estudante.email)where estudante.email = ?";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setString(1, email);

			ResultSet resultSet = comando.executeQuery();
			
			while (resultSet.next()) {
				
				Emblema emblema = new Emblema();
				emblema.setId(resultSet.getInt("id_emblema"));
				emblema.setNome(resultSet.getString("nome_emblema"));
				emblema.setIcon(resultSet.getInt("icon"));
			
				
				emblemas.add(emblema);
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
		
		return emblemas;
		
	}
    
}
