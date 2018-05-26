package com.mysystem.webservices;


import java.util.List;


import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@Path("/professor")
public class RestProfessor {
	
	   
	   //http://localhost:8080/ProjetoWSRestJSON/rest/user/client/all
	   @GET
	   @Path("/all")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Professor> getAllProfessores(){
		   List<Professor> professores;
		   ProfessorService service = new ProfessorService();
		   professores = service.getAllProfessores();
	       return professores;
	   }
	   

	   //http://localhost:8080/ProjetoWSRestJSON/rest/user/update
	  
	   
 
}
