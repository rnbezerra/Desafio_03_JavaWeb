package edu.infnet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.infnet.dao.AlunoDAO;
import br.infnet.dao.PresencaDAO;
import br.infnet.dao.TurmaDAO;
import br.infnet.dao.AulaDAO;
import br.infnet.domain.Aluno;
import br.infnet.domain.Aula;
import br.infnet.domain.Turma;

/**
 * Servlet implementation class Presenca
 */
@WebServlet("/GerenciarPresenca")
public class GerenciarPresenca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenciarPresenca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		AlunoDAO dao = new AlunoDAO();	
		PresencaDAO preDao = new PresencaDAO();
		AulaDAO aulaDao = new AulaDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String matricula = request.getParameter("matricula");
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		try {
			
			PresencaDAO presenca = new PresencaDAO();
			if (tipo == 0)
				presenca.marcarPresenca(id, matricula);
			else
				presenca.marcarAusencia(id, matricula);
			
			Aula aula = aulaDao.selecionar(id);
			
			request.getRequestDispatcher("ExibirAula?idAula="+id+"&idTurma="+aula.getTurma()).forward(request, response);
//			ExibirAula?idAula=${aula.id}&idTurma=${turma.id}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

}

