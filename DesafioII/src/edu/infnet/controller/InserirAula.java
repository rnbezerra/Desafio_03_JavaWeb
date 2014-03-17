package edu.infnet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.infnet.dao.AlunoDAO;
import br.infnet.dao.TurmaDAO;
import br.infnet.domain.Aluno;
import br.infnet.domain.Aula;
import br.infnet.domain.Turma;

/**
 * Servlet implementation class InserirAula
 */
@WebServlet("/InserirAula")
public class InserirAula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirAula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		AulaDAO dao = new AulaDAO();
//		TurmaDAO daoTurma = new TurmaDAO();
//		
//		int idTurma = Integer.parseInt(request.getParameter("turma").toString());
//		int idAula = Integer.parseInt(request.getParameter("aula").toString());
//		String data = request.getParameter("data");
//		
//		Aula aulaDTO = new Aula();
//		aulaDTO.setId(idAula);
//		aulaDTO.setData(data);
//		
//		try {
//			dao.inserir(aulaDTO);
//			
//			Turma turmaDTO = daoTurma.selecionar(idTurma);
//			
//			request.setAttribute("aula", aulaDTO);
//			request.setAttribute("turma", turmaDTO);
//			request.getRequestDispatcher("GestaoPauta.jsp").forward(request, response);
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e){
//			e.printStackTrace();
//		}		
	}

}
