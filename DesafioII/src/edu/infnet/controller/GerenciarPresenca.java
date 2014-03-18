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
		AulaDAO aulaDAO = new AulaDAO();
		TurmaDAO turmaDAO = new TurmaDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String matricula = request.getParameter("matricula");
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		int idAula = Integer.parseInt(request.getParameter("idAula"));
		try {
			List<Aluno> alunos = dao.selecionarPorTurma(id);
			List<Aluno> alunosPresentes = preDao.selecionarPorAula(idAula);
			List<Aula> aula = aulaDAO.selecionarPorTurma(id);
			Turma turma = turmaDAO.selecionar(id);
			
		
			
			
			PresencaDAO presenca = new PresencaDAO();
			if (tipo == 0)
				presenca.marcarPresenca(id, matricula);
			else
				presenca.marcarAusencia(id, matricula);
			
			request.setAttribute("alunolist", alunos);
			request.setAttribute("presentalunolist", alunosPresentes);
			request.setAttribute("aula", aula);
			request.setAttribute("turma", turma);
			
			request.getRequestDispatcher("GestaoAula.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

}

