package br.infnet.dao.testes;

import java.sql.SQLException;

import br.infnet.dao.AulaDAO;
import br.infnet.domain.Aula;

public class AulaDAOTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		AulaDAO a= new AulaDAO();
		Aula aula = a.selecionar(1);
		
		System.out.print(aula.getId() + "  " );
		System.out.print(aula.getNome()  + "  " );
		System.out.print(aula.getTurma()  + "  " );
		System.out.println(aula.getData().getTime() );
		
	/*	for (Aula aula : aulas) {
			System.out.print(aula.getId() + "  " );
			System.out.print(aula.getNome()  + "  " );
			System.out.print(aula.getTurma()  + "  " );
			System.out.println(aula.getData().getTime() );
		}*/
	}

}
