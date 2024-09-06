package br.edu.ifrn.sabetodo.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifrn.sabetodo.dao.EstudanteDAO;
import br.edu.ifrn.sabetodo.dominio.Estudante;


@Path("ranking")
public class RankingWS {
	
	@GET
	@Path("/buscarRanking")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudante> buscarRanking() {
		
		System.out.println("executando buscar ranking");
		EstudanteDAO dao = new EstudanteDAO();
		return dao.buscarRanking();
	
	}
	
}
