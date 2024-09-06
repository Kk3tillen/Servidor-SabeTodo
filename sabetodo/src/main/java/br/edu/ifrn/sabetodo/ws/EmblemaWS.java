package br.edu.ifrn.sabetodo.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifrn.sabetodo.dao.EmblemasDAO;
import br.edu.ifrn.sabetodo.dao.TarefaDAO;
import br.edu.ifrn.sabetodo.dominio.Emblema;
import br.edu.ifrn.sabetodo.dominio.Tarefa;

@Path("emblemas")
public class EmblemaWS {

	@GET
	@Path("/buscarEmblemas/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Emblema> buscarEmblemas(@PathParam("email") String email) {

		System.out.println("buscando emblemas");
		EmblemasDAO dao = new EmblemasDAO();

		List<Emblema> todas = dao.buscarEmblemas();
		List<Emblema> emblemasConquistadas = dao.buscarEmblemas(email);

		for(int i = 0; i < emblemasConquistadas.size(); i++) {
			for(int j = 0; j < todas.size(); j++) {
				if(emblemasConquistadas.get(i).getId() == todas.get(j).getId()) {
					todas.get(j).setConquistada(true);
				}
			}
		}
		return todas;

	}
}
