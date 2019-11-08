package Dados;

import java.sql.SQLException;
import java.util.ArrayList;
import BancoDados.Conexao;
import Negocio.Entidades.Aluno;

public class AlunoRepositorio {
	private ArrayList <Aluno> alunoslista;
	private Aluno aluno;

	public AlunoRepositorio() {
		alunoslista = new ArrayList <Aluno> ();
	}

	public ArrayList<Aluno> getAlunoslista() {
		return alunoslista;
	}

	public void setAlunoslista(ArrayList<Aluno> alunoslista) {
		this.alunoslista = alunoslista;
	}

	public void inserirAluno(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}


	public void buscarAlunos(String sql) {
		alunoslista.clear();

		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				aluno = new Aluno(Conexao.getInstance().getResultset().getString("cpf"),Conexao.getInstance().getResultset().getString("data_inicio"),Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo_curso")),
						Conexao.getInstance().getResultset().getString("numero_matricula"), Conexao.getInstance().getResultset().getString("ativo").charAt(0));
				alunoslista.add(aluno);
			}

		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);
	}


}
