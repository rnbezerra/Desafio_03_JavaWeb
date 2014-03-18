package edu.infnet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.infnet.dao.AulaDAO;
import br.infnet.dao.TurmaDAO;
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
		// TODO Auto-generated method stub
		
		TurmaDAO daoTurma = new TurmaDAO();
		
		int idTurma = Integer.parseInt(request.getParameter("turma").toString());

		try {
			
			Turma turmaDTO = daoTurma.selecionar(idTurma);
			
			request.setAttribute("turma", turmaDTO);
			request.getRequestDispatcher("AddAula.jsp")
				   .forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AulaDAO dao = new AulaDAO();
		TurmaDAO daoTurma = new TurmaDAO();
		
		System.out.println(request.getParameter("turma"));
		int idTurma = Integer.parseInt(request.getParameter("turma").toString());
		String aula = request.getParameter("aula");
		Calendar parsedDate = Calendar.getInstance();

		//converte a data
		try {
			String strDate = request.getParameter("data");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			parsedDate.setTime(sdf.parse(strDate));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Aula aulaDTO = new Aula();
		aulaDTO.setTurma(idTurma);
		aulaDTO.setNome(aula);
		aulaDTO.setData(Calendar.getInstance());
		
		try {
			dao.inserir(aulaDTO);
			
//			request.getRequestDispatcher("GerenciarPauta?id="+idTurma).forward(request, response);
			
			response.sendRedirect("GerenciarPauta?id="+idTurma);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}

}
