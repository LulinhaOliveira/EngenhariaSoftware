package Teste;

import BancoDados.Conexao;
import Dados.TurmaRepositorio;

public class Main {

	public static void main(String[] args) {
		TurmaRepositorio t = new TurmaRepositorio();


		Conexao.getInstance().conectar();
		t.Buscar1();
		
		System.out.println(t.getTurmalista().get(0).getNome());

		Conexao.getInstance().desconectar();

	}
}


