package Negocio;

import java.util.ArrayList;

import Dados.CursoRepositorio;
import Negocio.Entidades.Curso;

public class CursoControle {
	CursoRepositorio cp;
	
	public CursoControle() {
		cp = new CursoRepositorio();
	}
	
	public int buscarCodigo(String curso) {
		Curso c = new Curso (curso,"","");
		buscarCurso(c);
		
		return cp.getCursosLista().get(0).getCodigo();
	}
	
	public void inserirCurso(Curso curso) {
		String sql = "INSERT INTO curso(nome";
		String auxSQL = "VALUES (";

		auxSQL += "'" + curso.getNome() + "'";
		if(curso.getHorario_funcionamento() != null && curso.getHorario_funcionamento() != "") {
			sql += ",hora_funcionamento";
			auxSQL +=  ",'" + curso.getHorario_funcionamento() + "'" ;
		}
		if(curso.getCpf_coordenador() != null && curso.getCpf_coordenador() != "") {
			sql += ",cpf_coordenador";
			auxSQL += ",'" + curso.getCpf_coordenador() + "'";
		}
		sql += ")" + auxSQL + ")";
		
		cp.inserirCurso(sql);
	}
	
	public void buscarCurso(Curso curso) {
		String sql = "SELECT * FROM curso";
		String auxSQL = " WHERE ";
		int aux = 0;

		if(curso.getCodigo() != 0) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "codigo = " + curso.getCodigo();
				aux = 1;
			}
		}
		if(curso.getNome() != null && curso.getNome() != "") {
			if(aux == 0) {
				sql += auxSQL;
				sql += "nome = '" + curso.getNome() + "'";
				aux = 1;
			}else {
				sql += " AND " + " nome = '" + curso.getNome() + "'";
			}
		}
		if(curso.getCpf_coordenador() != null && curso.getCpf_coordenador() != "") {
			if(aux == 0) {
				sql += auxSQL;
				sql += "cpf_coordeandor = '" + curso.getCpf_coordenador() + "'";
				aux = 1;
			}else {
				sql += " AND " + "cpf_coordeandor = '" + curso.getCpf_coordenador() + "'";
			}
		}
		if(curso.getHorario_funcionamento() != null && curso.getHorario_funcionamento() != "") {
			if(aux == 0) {
				sql += auxSQL;
				sql += "hora_funcionamento = '" + curso.getHorario_funcionamento() + "'";
				aux = 1;
			}else {
				sql += " AND " + "hora_funcionamento = '" + curso.getHorario_funcionamento() + "'";
			}
		}
		if(curso.getAtivo() == 'N' || curso.getAtivo() == 'S') {
			if(aux == 0) {
				sql += auxSQL;
				sql += "ativo = '" + curso.getAtivo() + "'";
			}else {
				sql += " AND " + "ativo = '" + curso.getAtivo() + "'";
			}
		}
		
		cp.buscarCurso(sql);
	}

	public void inativarCurso(String curso) {
		int codigo =  buscarCodigo(curso);
		
		String sql = "UPDATE curso SET ativo = 'N' WHERE codigo = " + codigo;
		
		cp.inativarCurso(sql);
	}
	
	public void atualizarCurso(Curso novoCurso, String nomeCurso) {
		ArrayList <String> aux = new ArrayList <String> ();
		int codigo = buscarCodigo(nomeCurso);
		
		if (novoCurso.getNome() != null && novoCurso.getNome() != "") {
			String sql = "UPDATE curso SET nome = '" + novoCurso.getNome()  +"' WHERE codigo = " + codigo; 
			aux.add(sql);
		}
		if(novoCurso.getHorario_funcionamento() != null && novoCurso.getHorario_funcionamento() != "") {
			String sql = "UPDATE curso SET hora_funcionamento = '" + novoCurso.getHorario_funcionamento() +"' WHERE codigo = " + codigo; 
			aux.add(sql);

		}
		if(novoCurso.getCpf_coordenador() != null && novoCurso.getCpf_coordenador() != "") {
			String sql = "UPDATE curso SET cpf_coordenador = '" + novoCurso.getCpf_coordenador() + "' WHERE codigo = " + codigo;
			aux.add(sql);
		}
		cp.atualizarCurso(aux);
	
	}
}

