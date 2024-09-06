package br.edu.ifrn.sabetodo.ws;

import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifrn.sabetodo.dao.AlternativaDAO;
import br.edu.ifrn.sabetodo.dao.QuestaoDAO;
import br.edu.ifrn.sabetodo.dominio.Alternativa;
import br.edu.ifrn.sabetodo.dominio.EstudanteTarefa;
import br.edu.ifrn.sabetodo.dominio.Questao;

@Path("questoes")
public class QuestaoWS {

		@GET
		@Path("/buscarQuestoes/{idTarefa}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Questao> buscarQuestoes(@PathParam("idTarefa") int idTarefa) {
			System.out.println("Executando o método buscar questões ");
			
			QuestaoDAO dao = new QuestaoDAO();
			List<Questao> questoes = dao.buscarQuestoes(idTarefa);
			AlternativaDAO daoAlternativa = new AlternativaDAO();
			
			for(Questao q : questoes) {
				List<Alternativa> alternativas = daoAlternativa.buscarAlternativas(q.getId());
				q.setAlternativas(alternativas);
			}
			
			
			return questoes;
			
		
	}
		
		@GET
		@Path("/questaoRoletaAleatoria/{idDificuldade}")
		@Produces(MediaType.APPLICATION_JSON)
		public Questao questaoRoletaAleatoriaPorDificuldadeId(@PathParam("idDificuldade") int idDificuldade) {
			
			
			QuestaoDAO dao = new QuestaoDAO();
			
			Questao q = (Questao) dao.questaoRoletaAleatoriaPorDificuldadeId(idDificuldade);
			
			
			AlternativaDAO daoAlternativa = new AlternativaDAO();
			List<Alternativa> alternativas = daoAlternativa.buscarAlternativas(q.getId());
			q.setAlternativas(alternativas);

			return q;	
			
	}
		
		@GET
		@Path("/buscarQuestao/{idTarefa}/{email}")
		@Produces(MediaType.APPLICATION_JSON)
		public Questao buscarQuestao(@PathParam("idTarefa") int idTarefa, @PathParam("email") String email) {
			
			System.out.println("Executando o método buscar questão ");
			QuestaoDAO dao = new QuestaoDAO();
			
			Questao q = dao.buscarQuestao(idTarefa, email);
			
			
			AlternativaDAO daoAlternativa = new AlternativaDAO();
			List<Alternativa> alternativas = daoAlternativa.buscarAlternativas(q.getId());
			q.setAlternativas(alternativas);

			return q;	
	}
		
		@PUT
		@Path("/registrar")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public boolean registrar(EstudanteTarefa estudanteTarefa) {
			
			QuestaoDAO questaoDAO = new QuestaoDAO();
			return questaoDAO.registrar(estudanteTarefa);
		}
		
		//SELECT enunciado, pontuacao, id, audio, imagem, imagem2, enunciado2, ordem FROM questao where tarefa_id =5 and ordem = (select ordem from estudante_tarefa where estudante_email = 'k.kezia@escolar.ifrn.edu.br' and tarefa_id = 5);
	
}
