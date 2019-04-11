package br.com.activity.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.activity.dao.ProfessorDAO;

@Path("/conta")
public class ProfessorServico {

	private static final String CHARSET_UTF8 = ";charset=utf-8";

	@Path("/hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello Jersey";
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public String createAccount(String email, String password, String name) {
		String msg = "";
		try {
			ProfessorDAO.dbCreateAccount(email, password, name);
			msg = String.valueOf("foi");
		} catch (Exception e) {
			msg = "Erro ao add a conta!";
			e.printStackTrace();
		}
		return msg;

	}

}
