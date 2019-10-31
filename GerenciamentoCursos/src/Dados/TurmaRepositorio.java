package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import BancoDados.Conexao;
import Negocio.Entidades.Turma;

public class TurmaRepositorio {

	private ArrayList <Turma> turmalista ;
	Turma turma ;
    
	
	public ArrayList<Turma> getTurmalista() {
		return turmalista;
	}

	public void setTurmalista(ArrayList<Turma> turmalista) {
		this.turmalista = turmalista;
	}

	
	public TurmaRepositorio(){
		turmalista = new ArrayList <Turma> ();
    }
	
	//Exemplo Teste
	public void Buscar1() {
		turmalista.clear();
		String sql = "SELECT * FROM turma";
		Conexao.getInstance().buscarSQL(sql);
		
		try {
			while(Conexao.getInstance().getResultset().next()) {
				turma = new Turma(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")),Conexao.getInstance().getResultset().getString("nome"),
						Conexao.getInstance().getResultset().getString("sigla"), Conexao.getInstance().getResultset().getString("turno"), Conexao.getInstance().getResultset().getString("semestre"),
						Conexao.getInstance().getResultset().getString("ativo").charAt(0));
				turmalista.add(turma);
				Conexao.getInstance().setResultset(null);
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

