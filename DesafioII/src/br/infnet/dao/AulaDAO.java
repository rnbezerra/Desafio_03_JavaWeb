package br.infnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.infnet.domain.Aula;

public class AulaDAO extends BaseDAO{
	
        public void inserir(Aula aula) throws ClassNotFoundException, SQLException{

        	String sql = "INSERT INTO \"Aula\" (\"nome\", \"IdTurma\", \"Data\") VALUES (?, ?, ?)";
        	
		    java.sql.Timestamp timestamp = new java.sql.Timestamp(aula.getData().getTimeInMillis());
		    
		    Connection conexao = getConexao();
		        PreparedStatement query = conexao.prepareStatement(sql);
		        query.setString(1, aula.getNome());
		        query.setInt(2, aula.getTurma());
		        query.setTimestamp(3, timestamp);
		        query.execute();
        }
        
        
        public void atualizar(Aula aula) throws ClassNotFoundException,
        SQLException {
        
        	java.sql.Timestamp timestamp = new java.sql.Timestamp(aula.getData().getTimeInMillis());
        	
        	String sql = "UPDATE \"Aula\""
        			+ "SET \"nome\" = ?,"
        			+ " \"IdTurma\" = ?,"
        			+ " \"Data\" = ? "
					+ "WHERE \"id\" = ? ";
        	
    		Connection conexao = getConexao();
    		PreparedStatement query = conexao.prepareStatement(sql);
    		query.setString(1, aula.getNome());
    		query.setInt(2, aula.getTurma() );
    		query.setTimestamp(3, timestamp);
    		query.setInt(4, aula.getId() );
    		query.execute();
        	
        }
        
        public void excluir(Integer aulaID) throws ClassNotFoundException,
        SQLException {

        	String sql = "DELETE FROM \"Aula\""
					+ "WHERE \"id\" = ? ";
        	
    		Connection conexao = getConexao();
    		PreparedStatement query = conexao.prepareStatement(sql);
    		query.setInt(1, aulaID);
    		query.execute();

        }

        
        public List<Aula> selecionarPorTurma(Integer idTurma) throws ClassNotFoundException, SQLException {
        	
    		Connection conexao = getConexao();
    		
    		String sql = "SELECT \"id\", \"nome\", \"IdTurma\", \"Data\" "
    					+ "FROM \"Aula\""
    					+ "WHERE \"IdTurma\" = ? ";
    		
    		PreparedStatement query = conexao.prepareStatement(sql);
    		query.setInt(1, idTurma);
    		ResultSet resultados = query.executeQuery();
    		ArrayList<Aula> aulas = new ArrayList<Aula>();
    		while (resultados.next()) {
    			Aula aula = new Aula();
    			aula.setId(resultados.getInt("id"));
    			aula.setNome(resultados.getString("nome"));
    			aula.setTurma(resultados.getInt("IdTurma") );
    			aula.setData( Calendar.getInstance() );
    			aula.getData().setTime( resultados.getDate("Data") );
    			aulas.add(aula);
    		}
        	
        	return aulas;
        }

        
        public Aula selecionar(Integer aulaID) throws ClassNotFoundException,SQLException {
        	Connection conexao = getConexao();
        	
        	String sql = "SELECT \"id\", \"nome\", \"IdTurma\", \"Data\" "
						+ "FROM \"Aula\""
						+ "WHERE \"id\" = ? ";
        	
    		PreparedStatement query = conexao.prepareStatement(sql);
    		query.setInt(1, aulaID);
    		ResultSet resultados = query.executeQuery();
    		Aula aula = null;
    		
    		if (resultados.next()) {
    			aula = new Aula();
    			aula.setId(resultados.getInt("id"));
    			aula.setNome(resultados.getString("nome"));
    			aula.setTurma(resultados.getInt("IdTurma") );
    			aula.setData( Calendar.getInstance() );
    			aula.getData().setTime( resultados.getDate("Data") );
    		}
    		return aula;
        }
        
}