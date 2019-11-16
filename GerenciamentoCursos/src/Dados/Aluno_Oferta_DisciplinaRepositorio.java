package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancoDados.Conexao;
import Negocio.Entidades.Aluno_Oferta_Disciplina;

public class Aluno_Oferta_DisciplinaRepositorio {
	private ArrayList <Aluno_Oferta_Disciplina> aluno_oferta_disciplinaLista;
	private Aluno_Oferta_Disciplina aluno_disciplina;
	
	public Aluno_Oferta_DisciplinaRepositorio() {
		aluno_oferta_disciplinaLista = new ArrayList <Aluno_Oferta_Disciplina> ();
	}

	public ArrayList<Aluno_Oferta_Disciplina> getAluno_oferta_disciplinaLista() {
		return aluno_oferta_disciplinaLista;
	}

	public void setAluno_oferta_disciplinaLista(ArrayList<Aluno_Oferta_Disciplina> aluno_oferta_disciplinaLista) {
		this.aluno_oferta_disciplinaLista = aluno_oferta_disciplinaLista;
	}
	
	public void inserirAluno_Oferta(String sql) {
		int rowInsered = Conexao.getInstance().executaSQL(sql);
		if(rowInsered == 200) {
			JOptionPane.showMessageDialog(null, "Matricula Realizada com Sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao Fazer Matricula");
		}
	}
	
	public void buscarAluno_Disciplina(String sql) {
		aluno_oferta_disciplinaLista.clear();
		Conexao.getInstance().buscarSQL(sql);
		
		try {
			while(Conexao.getInstance().getResultset().next()) {
				aluno_disciplina = new Aluno_Oferta_Disciplina(Conexao.getInstance().getResultset().getString("cpf"),Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")),Double.parseDouble(Conexao.getInstance().getResultset().getString("nota_1")),
						Double.parseDouble(Conexao.getInstance().getResultset().getString("nota_2")), Double.parseDouble(Conexao.getInstance().getResultset().getString("media_final")), 
						Integer.parseInt(Conexao.getInstance().getResultset().getString("frequencia")),
						Conexao.getInstance().getResultset().getString("ativo"));
				aluno_oferta_disciplinaLista.add(aluno_disciplina);
			}
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);
	}
	
	
	public void atualizarAluno_Disciplina(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	
	public void alterarStatus(String sql) {
		Conexao.getInstance().executaSQL(sql);

	}
}
