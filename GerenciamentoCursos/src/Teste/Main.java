package Teste;

import BancoDados.Conexao;
import Dados.TurmaRepositorio;
import Negocio.Entidades.Turma;

public class Main {

	public static void main(String[] args) {
		TurmaRepositorio t = new TurmaRepositorio();
		
		Turma turma1 =  new Turma("TurmaTeste","TT","Manha","2017.1");
		
		Conexao.getInstance().conectar();
		t.InserirTurma(turma1);
		
		
		Conexao.getInstance().desconectar();
		

	}

}
