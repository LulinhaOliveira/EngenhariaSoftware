package Dados;

import java.util.ArrayList;

import BancoDados.Conexao;
import Negocio.Entidades.Turma;

public class TurmaRepositorio {

	ArrayList <Turma> turmalista ;
	Turma turma ;
    
	public TurmaRepositorio(){
		turmalista = new ArrayList <Turma> ();
    }
	public void InserirTurma(Turma turma) {
		try {
			String sql = "INSERT INTO turma(nome,sigla,turno,semestre) "
					+ "VALUES ('" + turma.getNome() + "','" + turma.getSigla() + "','" + turma.getTurno() + "','" + turma.getSemestre()+"')";
			Conexao.getInstance().getStatement().executeUpdate(sql);
		}catch(Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	public void Buscar() {
		turmalista.clear();
		try {
			String sql = "SELECT * FROM turma";
			Conexao.getInstance().setResultset(Conexao.getInstance().getStatement().executeQuery(sql));
			Conexao.getInstance().setStatement(Conexao.getInstance().getConnection().createStatement());

			while(Conexao.getInstance().getResultset().next()) {
				turma = new Turma(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")),Conexao.getInstance().getResultset().getString("nome"),
						Conexao.getInstance().getResultset().getString("sigla"), Conexao.getInstance().getResultset().getString("turno"), Conexao.getInstance().getResultset().getString("semestre"),
						Conexao.getInstance().getResultset().getString("ativo").charAt(0));
				turmalista.add(turma);

			}

		}catch(Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}

