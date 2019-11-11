package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import BancoDados.Conexao;
import Dados.DisciplinaRepositorio;
import Negocio.Entidades.Disciplina;

public class DisciplinaControle {
	private DisciplinaRepositorio dr;

	public DisciplinaControle() {
		dr = new DisciplinaRepositorio();
	}



	public DisciplinaRepositorio getDr() {
		return dr;
	}



	public void setDr(DisciplinaRepositorio dr) {
		this.dr = dr;
	}



	public int buscarCodigo(String disciplina, int codigo, String cpf) {
		String sql = "SELECT * FROM disciplina WHERE nome = '" + disciplina  + "' AND ativo = 'S'"; 

		if(codigo != 0) {
			sql +=  " AND codigo_curso = " + codigo;
		}else {
			String sql1 = "SELECT * FROM oferta_disciplina JOIN disciplina ON oferta_disciplina.codigo = disciplina.codigo "
					+ "WHERE oferta_disciplina.cpf = '" + cpf + "' AND disciplina.nome = '" + disciplina +"'";
			int curso = -1;
			Conexao.getInstance().buscarSQL(sql1);
			
			try {
				while(Conexao.getInstance().getResultset().next()) {
					curso = Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo_curso"));
				}
			} catch (NumberFormatException e){
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			Conexao.getInstance().setResultset(null);
		
			sql += " AND codigo_curso = " + curso;
		}
		Conexao.getInstance().buscarSQL(sql);
		int codigo2 = -1;
		try {
			while(Conexao.getInstance().getResultset().next()) {
				codigo2 = Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo"));
			}
		} catch (NumberFormatException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		Conexao.getInstance().setResultset(null);
		
		return codigo2;
	}

	public void buscarDisciplina(Disciplina disciplina) {
		String sql = "SELECT * FROM disciplina";
		String auxSQL = " WHERE ";
		int aux = 0;

		if(disciplina.getCodigo() != 0) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "codigo = " + disciplina.getCodigo();
				aux = 1;
			}
		}
		if(disciplina.getNome() != null && disciplina.getNome() != "") {
			if(aux == 0) {
				sql += auxSQL;
				sql += "nome = '" + disciplina.getNome() + "'";
				aux = 1;
			}else {
				sql += " AND " + " nome = '" + disciplina.getNome() + "'";
			}
		}
		if(disciplina.getEmenta() != null && disciplina.getEmenta() != "") {
			if(aux == 0) {
				sql += auxSQL;
				sql += "ementa = '" + disciplina.getEmenta() + "'";
				aux = 1;
			}else {
				sql += " AND " + "ementa = '" + disciplina.getEmenta() + "'";
			}
		}
		if(disciplina.getNumero_creditos() != 0) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "num_creditos = '" + disciplina.getNumero_creditos() + "'";
				aux = 1;
			}else {
				sql += " AND " + "num_creditos = '" + disciplina.getNumero_creditos() + "'";
			}
		}
		if(disciplina.getAtivo() == 'N' || disciplina.getAtivo() == 'S') {
			if(aux == 0) {
				sql += auxSQL;
				sql += "ativo = '" + disciplina.getAtivo() + "'";
				aux = 1;
			}else {
				sql += " AND " + "ativo = '" + disciplina.getAtivo() + "'";
			}
		}
		if(disciplina.getCodigo_curso() != 0) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "codigo_curso = " + disciplina.getCodigo_curso();
				aux = 1;
			}else {
				sql += " AND " + "codigo_curso = " + disciplina.getCodigo_curso();
			}
		}
		if(disciplina.getCodigo_turma() != 0) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "codigo_turma = " + disciplina.getCodigo_turma();
				aux = 1;
			}else {
				sql += " AND " + "codigo_turma = " + disciplina.getCodigo_turma();
			}
		}
		dr.buscarDisciplina(sql);
	}

	public void inserirDisciplina(Disciplina disciplina) {
		String sql = "INSERT INTO disciplina(nome";
		String auxSQL = "VALUES (";

		auxSQL += "'" + disciplina.getNome() + "'";

		if(disciplina.getCodigo_curso() != 0) {
			sql += ",codigo_curso";
			auxSQL +=  ",'" + disciplina.getCodigo_curso() + "'" ;
		}
		if(disciplina.getCodigo() != 0) {
			sql += ",codigo";
			auxSQL += ",'" + disciplina.getCodigo() + "'";
		}
		if(disciplina.getEmenta() !=" " && disciplina.getEmenta() != null) {
			sql += ",ementa";
			auxSQL += ",'" +disciplina.getEmenta() +"'";
		}
		if(disciplina.getNumero_creditos() != 0) {
			sql += ",num_creditos";
			auxSQL += ",'"+disciplina.getNumero_creditos() +"'";
		}
		if(disciplina.getCodigo_turma() !=0) {
			sql += ",codigo_turma";
			auxSQL += ",'"+disciplina.getCodigo_turma()+"'";
		}
		sql += ")" + auxSQL + ")";
	
		dr.inserirDisciplina(sql);
	}

	public void inativarDisciplina(String disciplina, int codigo_curso) {
		int codigo =  buscarCodigo(disciplina, codigo_curso,"");

		String sql = "UPDATE disciplina SET ativo = 'N' WHERE codigo = " + codigo + "AND codigo_curso = " + codigo_curso;

		dr.inativarDisciplina(sql);
	}

	public void atualizarDisciplina(Disciplina novaDisciplina, String nomeDisicplina, int codigo_curso) {
		ArrayList <String> aux = new ArrayList <String> ();
		int codigo = buscarCodigo(nomeDisicplina, codigo_curso,"");

		if (novaDisciplina.getNome() != null && novaDisciplina.getNome() != "") {
			String sql = "UPDATE disciplina SET nome = '" + novaDisciplina.getNome()  +"' WHERE codigo = " + codigo; 
			aux.add(sql);
		}
		if(novaDisciplina.getEmenta() != null && novaDisciplina.getEmenta() != "") {
			String sql = "UPDATE disciplina SET ementa = '" + novaDisciplina.getEmenta() +"' WHERE codigo = " + codigo; 
			aux.add(sql);

		}
		if(novaDisciplina.getCodigo_curso() != 0 ) {
			String sql = "UPDATE disciplina SET codigo_curso = '" + novaDisciplina.getCodigo_curso() + "' WHERE codigo = " + codigo;
			aux.add(sql);
		}
		if(novaDisciplina.getCodigo_turma() != 0) {
			String sql = "UPDATE disciplina SET codigo_turma = '" + novaDisciplina.getCodigo_turma() + "' WHERE codigo = " + codigo;
			aux.add(sql);
		}
		dr.atualizarDisciplina(aux);

	}


}
