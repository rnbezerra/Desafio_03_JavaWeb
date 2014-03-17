package br.infnet.dao;

import java.sql.SQLException;
import java.util.List;
import br.infnet.domain.Aula;

public class AulaDAO extends BaseDAO{

        
        public void inserir(Aula aula) throws ClassNotFoundException,
                        SQLException{
        }
        
        
        public void atualizar(Aula aula) throws ClassNotFoundException,
        SQLException {
        	
        }
        
        public void excluir(Integer aulaID) throws ClassNotFoundException,
        SQLException {

        }

        
        public List<Aula> selecionarPorTurma(int idTurma) throws ClassNotFoundException, SQLException {
        	return null;
        }

        
        public Aula selecionar(Integer aulaID) throws ClassNotFoundException,SQLException {
        	return null;
        }
        
}