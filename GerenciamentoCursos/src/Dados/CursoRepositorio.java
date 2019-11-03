package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import BancoDados.Conexao;
import Negocio.Entidades.Curso;

public class CursoRepositorio {

	private ArrayList <Curso> cursosLista; 
	Curso curso;

	public CursoRepositorio (){
		cursosLista = new ArrayList <Curso>();
	}
	public ArrayList<Curso> getCursosLista() {
		return cursosLista;
	}

	public void setCursosLista(ArrayList<Curso> cursosLista) {
		this.cursosLista = cursosLista;
	}

	
	//INSERIR CURSO
	public void inserirCurso(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	//INATIVAR CURSO
	public void inativarCurso(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	//ATUALIZAR DADOS DO CURSO
	public void atualizarCurso(ArrayList <String> array) {
		for(String a : array) {
			Conexao.getInstance().executaSQL(a);
		}
	}
	//BUSCAR CURSOS
	public void buscarCurso(String sql) {
		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				curso = new Curso(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")), Conexao.getInstance().getResultset().getString("nome")
						,Conexao.getInstance().getResultset().getString("hora_funcionamento"),Conexao.getInstance().getResultset().getString("ativo").charAt(0),
						Conexao.getInstance().getResultset().getString("cpf_coordenador"));
				cursosLista.add(curso);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);	
	}
}