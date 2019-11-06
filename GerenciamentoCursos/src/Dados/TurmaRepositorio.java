package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import BancoDados.Conexao;
import Negocio.Entidades.Turma;

public class TurmaRepositorio {

	private ArrayList <Turma> turmalista ;
	Turma turma ;
    
	public TurmaRepositorio(){
		turmalista = new ArrayList <Turma> ();
    }
	
	public ArrayList<Turma> getTurmalista() {
		return turmalista;
	}

	public void setTurmalista(ArrayList<Turma> turmalista) {
		this.turmalista = turmalista;
	}

	public void inserirTurma(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	
	public void atualizarTurma(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	
	public void inativarTurma(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	
	public void buscarTurma(String sql) {
		turmalista.clear();
		
		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				turma = new Turma(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")),Conexao.getInstance().getResultset().getString("nome"),
						Conexao.getInstance().getResultset().getString("sigla"), Conexao.getInstance().getResultset().getString("turno"), Conexao.getInstance().getResultset().getString("semestre"),
						Conexao.getInstance().getResultset().getString("ativo").charAt(0));
				turmalista.add(turma);
			}
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);
	}
	
}

