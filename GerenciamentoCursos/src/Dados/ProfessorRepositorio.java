package Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancoDados.Conexao;
import Negocio.Entidades.Professor;
import Negocio.Entidades.Usuario;

public class ProfessorRepositorio {
	private ArrayList <Professor> listaProfessor;
	Professor professor;

	public ProfessorRepositorio() {
		setListaProfessor(new ArrayList <Professor>());
	}

	public ArrayList <Professor> getListaProfessor() {
		return listaProfessor;
	}

	public void setListaProfessor(ArrayList <Professor> listaProfessor) {
		this.listaProfessor = listaProfessor;
	}
	
	public void inserirProfessor(String sql) {
		try {
			int rowInsered = Conexao.getInstance().executaSQL(sql);
			if (rowInsered == 200) {
				JOptionPane.showMessageDialog(null, "Professor inserido com sucesso");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
