package br.infnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.infnet.domain.Aluno;

public class PresencaDAO extends BaseDAO{

	public void marcarPresenca( Integer aulaId, String matricula ) throws ClassNotFoundException, SQLException
	{
		Connection conexao = getConexao();
		
		String sql = "INSERT INTO \"PresencaAula\" (idaula, matricula) VALUES (?, ?)";
		
		PreparedStatement query = conexao.prepareStatement(sql);
		query.setInt(1, aulaId);
		query.setString(2, matricula);
		query.execute();
		
	}
	
	public void marcarAusencia( Integer aulaId, String matricula ) throws ClassNotFoundException, SQLException
	{
		Connection conexao = getConexao();
		
		String sql = "DELETE FROM \"PresencaAula\" WHERE \"idaula\"=? AND \"matricula\"=?;";
		
		PreparedStatement query = conexao.prepareStatement(sql);
		query.setInt(1, aulaId);
		query.setString(2, matricula);
		query.execute();
	}
	
	public List<Aluno> selecionarPorAula(Integer aulaId) throws ClassNotFoundException, SQLException
	{
		Connection conexao = getConexao();
		
		String sql= "SELECT a.matricula AS matricula, a.nome AS nome " +
					"FROM \"Aluno\" AS a " +
						"INNER JOIN \"PresencaAula\" AS p " +
						"ON (a.matricula = p.matricula) " +
					"WHERE p.idaula = ?";
		
		PreparedStatement query = conexao.prepareStatement(sql);
		query.setInt(1, aulaId);
		
		ResultSet resultados = query.executeQuery();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		while (resultados.next()) {
			Aluno aluno = new Aluno();
			aluno.setMatricula(resultados.getString("matricula"));
			aluno.setNome(resultados.getString("nome"));
			alunos.add(aluno);
		}
		
		return alunos;
		
	}
	
}
