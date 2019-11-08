package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import BancoDados.Conexao;
import Negocio.Entidades.Oferta_Disciplina;

public class Oferta_DisciplinaRepositorio {
	private ArrayList <Oferta_Disciplina> oferta_disciplinalista;
	private Oferta_Disciplina oferta;
	
	public Oferta_DisciplinaRepositorio() {
		oferta_disciplinalista = new ArrayList <Oferta_Disciplina> ();
	}

	public ArrayList<Oferta_Disciplina> getOferta_disciplinalista() {
		return oferta_disciplinalista;
	}

	public void setOferta_disciplinalista(ArrayList<Oferta_Disciplina> oferta_disciplinalista) {
		this.oferta_disciplinalista = oferta_disciplinalista;
	}
	
	
	public void inserirOferta_Disciplina(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	
	public void inativarOferta_Disciplina(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	
	public void disciplinasOfertadas(String sql) {
		oferta_disciplinalista.clear();
		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				oferta = new Oferta_Disciplina(Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo")), Conexao.getInstance().getResultset().getString("dia_1")
						,Conexao.getInstance().getResultset().getString("dia_2"),Conexao.getInstance().getResultset().getString("hora_1"),Conexao.getInstance().getResultset().getString("hora_2"),Conexao.getInstance().getResultset().getString("ativo").charAt(0),
						Conexao.getInstance().getResultset().getString("cpf"));
				oferta_disciplinalista.add(oferta);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);	
	}
	
	
	public void atualizarOferta_Disciplina(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}
	
}
