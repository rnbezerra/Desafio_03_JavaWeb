package br.infnet.dao.testes;

import java.sql.SQLException;
import java.util.List;

import br.infnet.dao.PresencaDAO;
import br.infnet.domain.Aluno;

public class PresencaDAOTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		PresencaDAO p = new PresencaDAO();
		
		List<Aluno> alunos =  p.selecionarPorAula(1);
		
		for (Aluno aluno : alunos) {
			System.out.print( aluno.getMatricula() + " " );
			System.out.print( aluno.getNome() + " " );
			System.out.println();
		}
		
	}

}
