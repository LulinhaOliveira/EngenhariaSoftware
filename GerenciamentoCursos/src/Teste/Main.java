package Teste;

import BancoDados.Conexao;
import Negocio.CursoControle;
import Negocio.Entidades.Curso;

public class Main {

	public static void main(String[] args) {
		Curso c = new Curso("CursoAtualizado","13:00 as 17:00","");
		CursoControle cc = new CursoControle();
		
		Conexao.getInstance().conectar();
		
		cc.inativarCurso("CursoAtualizado");
		
		Conexao.getInstance().desconectar();
	}
}


