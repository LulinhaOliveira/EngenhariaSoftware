package Dados;

import java.util.ArrayList;

import BancoDados.Conex�o;
import Negocio.Entidades.Turma;

public class TurmaRepositorio {

	ArrayList <Turma> turmalista = new ArrayList <Turma> ();
	Turma turma ;

	public void InserirTurma(Turma turma) {
		try {
			String sql = "INSERT INTO turma(nome,sigla,turno,semestre) "
					+ "VALUES ('" + turma.getNome() + "','" + turma.getSigla() + "','" + turma.getTurno() + "','" + turma.getSemestre()+"')";
			Conex�o.getInstance().getStatement().executeQuery(sql);
		}catch(Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	public void Buscar() {
		turmalista.clear();
		try {
			String sql = "SELECT * FROM turma";
			Conex�o.getInstance().setResultset(Conex�o.getInstance().getStatement().executeQuery(sql));
			Conex�o.getInstance().setStatement(Conex�o.getInstance().getConnection().createStatement());

			while(Conex�o.getInstance().getResultset().next()) {
				turma = new Turma(Integer.parseInt(Conex�o.getInstance().getResultset().getString("codigo")),Conex�o.getInstance().getResultset().getString("nome"),
						Conex�o.getInstance().getResultset().getString("sigla"), Conex�o.getInstance().getResultset().getString("turno"), Conex�o.getInstance().getResultset().getString("semestre"),
						Conex�o.getInstance().getResultset().getString("ativo").charAt(0));
				turmalista.add(turma);

			}

		}catch(Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}

