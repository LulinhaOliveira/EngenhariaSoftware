package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import BancoDados.Conexao;
import Negocio.Entidades.Disciplina;

public class DisciplinaRepositorio {
	private ArrayList <Disciplina> disciplinaLista; 
	Disciplina disciplina;
	
	
	public DisciplinaRepositorio (){
		disciplinaLista = new ArrayList <Disciplina>();
	}
	public ArrayList<Disciplina> getDisciplinaLista() {
		return disciplinaLista;
	}

	public void setDisciplinaLista(ArrayList<Disciplina> disciplinaLista) {
		this.disciplinaLista = disciplinaLista;
	}

	//INSERIR DISCIPLINA
		public void inserirDisciplina(String sql) {
			Conexao.getInstance().executaSQL(sql);
		}
		//INATIVAR DISCIPLINA
		public void inativarDisciplina(String sql) {
			Conexao.getInstance().executaSQL(sql);
		}
		//ATUALIZAR DADOS DA DISCIPLINA
		public void atualizarDisciplina(ArrayList <String> array) {
			for(String a : array) {
				Conexao.getInstance().executaSQL(a);
			}
		}
		
	//BUSCAR DISCIPLINA
		public void buscarDisciplina(String sql) {
		Conexao.getInstance().buscarSQL(sql);
		disciplinaLista.clear();
		try {
			while(Conexao.getInstance().getResultset().next()) {
				disciplina = new Disciplina(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo"))
						,Conexao.getInstance().getResultset().getString("nome")
						,Conexao.getInstance().getResultset().getString("ementa")
						,Integer.parseInt(Conexao.getInstance().getResultset().getString("num_creditos"))
						,Conexao.getInstance().getResultset().getString("ativo").charAt(0)
						,Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo_curso"))
						,Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo_turma")));
				disciplinaLista.add(disciplina);
			}
		} catch (NumberFormatException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		Conexao.getInstance().setResultset(null);
		}
		
		
}
