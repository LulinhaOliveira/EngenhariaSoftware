package Dados;

import BancoDados.Conexao;

public class Aluno_TurmaRepositorio {

	
	public Aluno_TurmaRepositorio() {
		
	}
	
	public void inserirAluno_Turma(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	
	public void removerAluno_Turma(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	
}
