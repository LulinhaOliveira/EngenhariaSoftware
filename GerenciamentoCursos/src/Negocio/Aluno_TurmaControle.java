package Negocio;

import java.sql.SQLException;

import BancoDados.Conexao;
import Dados.Aluno_TurmaRepositorio;
import Negocio.Entidades.Aluno_Turma;

public class Aluno_TurmaControle {
	
	private Aluno_TurmaRepositorio atr ;

	public Aluno_TurmaControle(){
		atr = new Aluno_TurmaRepositorio ();
	}

	public Aluno_TurmaRepositorio getAtr() {
		return atr;
	}

	public void setAtr(Aluno_TurmaRepositorio atr) {
		this.atr = atr;
	}

	public void inserirAluno_Turma(Aluno_Turma at) {
		String sql = "INSERT INTO aluno_turma(cpf,codigo) VALUES ('" + at.getCpf() + "'," + at.getCodigo() + ")";
		atr.inserirAluno_Turma(sql);
	}
	
	public void removerAluno_Turma(int codigo) {
		String sql = "DELETE FROM aluno_turma WHERE codigo  =" + codigo; 
		atr.removerAluno_Turma(sql);
	}
	
	public boolean  verificarAlunoPendenteTurma(int codigo) {
		String sql = "SELECT COUNT(*) as contador FROM aluno_turma WHERE aluno_turma.codigo = " + codigo;

		Conexao.getInstance().buscarSQL(sql);
		
		int cont = -1;
		try {
			while(Conexao.getInstance().getResultset().next()) {
			 cont = Integer.parseInt(Conexao.getInstance().getResultset().getString("contador"));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);	
		if(cont == 0) {
			return true;
		}
		return false;
	}
}
	