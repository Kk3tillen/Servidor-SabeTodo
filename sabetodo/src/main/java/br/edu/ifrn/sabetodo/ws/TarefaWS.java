package br.edu.ifrn.sabetodo.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifrn.sabetodo.dao.TarefaDAO;
import br.edu.ifrn.sabetodo.dominio.Tarefa;

@Path("tarefas")
public class TarefaWS {

	@GET
	@Path("/buscarTarefas/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tarefa> buscarTarefas(@PathParam("email") String email) {
		
		System.out.println("Executando metodo buscar tarefas");
		TarefaDAO dao = new TarefaDAO();
		
		List<Tarefa> todas = dao.buscarTarefas();
		List<Tarefa> tarefasEstudante = dao.buscarTarefas(email);
		
		for(int i = 0; i < tarefasEstudante.size(); i++) {
			for(int j = 0; j < todas.size(); j++) {
				if(tarefasEstudante.get(i).getId() == todas.get(j).getId()) {
					
					if(tarefasEstudante.get(i).getEstaNaTarefa()) {
						todas.get(j).setEstaNaTarefa(true);
					}
					
					if(tarefasEstudante.get(i).getProgresso() == 100){
						todas.get(j).setConcluida(true);
					}
					
				}
			}
		}
		
		return todas;
		
	}
}
