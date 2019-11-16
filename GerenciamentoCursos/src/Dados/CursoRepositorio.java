package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		int rowInsered = Conexao.getInstance().executaSQL(sql);
		if(rowInsered == 200) {
			JOptionPane.showMessageDialog(null, "Curso Inserido com Sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao Inserir Curso");
		}
	}
	//INATIVAR CURSO
	public void inativarCurso(String sql) {
		int rowInsered = Conexao.getInstance().executaSQL(sql);
		if(rowInsered == 200) {
			JOptionPane.showMessageDialog(null, "Curso Inativado com Sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao Inativar Curso");
		}
	}
	//ATUALIZAR DADOS DO CURSO
	public void atualizarCurso(String sql) {
		int rowInsered = Conexao.getInstance().executaSQL(sql);
		if(rowInsered == 200) {
			JOptionPane.showMessageDialog(null, "Curso Atualizado com Sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Erro em Uma ou Mais Atualizações");
		}
	}
	
	//BUSCAR CURSOS
	public void buscarCurso(String sql) {
		cursosLista.clear();
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