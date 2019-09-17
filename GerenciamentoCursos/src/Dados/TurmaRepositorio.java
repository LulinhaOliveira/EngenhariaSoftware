package Dados;

import java.util.ArrayList;

import BancoDados.Conexão;
import Negocio.Entidades.Turma;

public class TurmaRepositorio {

	ArrayList <Turma> turmalista = new ArrayList <Turma> ();
	Turma turma ;

	public void InserirTurma(Turma turma) {
		try {
			String sql = "INSERT INTO turma(nome,sigla,turno,semestre) "
					+ "VALUES ('" + turma.getNome() + "','" + turma.getSigla() + "','" + turma.getTurno() + "','" + turma.getSemestre()+"')";
			Conexão.getInstance().getStatement().executeQuery(sql);
		}catch(Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	public void Buscar() {
		turmalista.clear();
		try {
			String sql = "SELECT * FROM turma";
			Conexão.getInstance().setResultset(Conexão.getInstance().getStatement().executeQuery(sql));
			Conexão.getInstance().setStatement(Conexão.getInstance().getConnection().createStatement());

			while(Conexão.getInstance().getResultset().next()) {
				turma = new Turma(Integer.parseInt(Conexão.getInstance().getResultset().getString("codigo")),Conexão.getInstance().getResultset().getString("nome"),
						Conexão.getInstance().getResultset().getString("sigla"), Conexão.getInstance().getResultset().getString("turno"), Conexão.getInstance().getResultset().getString("semestre"),
						Conexão.getInstance().getResultset().getString("ativo").charAt(0));
				turmalista.add(turma);

			}

		}catch(Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}

