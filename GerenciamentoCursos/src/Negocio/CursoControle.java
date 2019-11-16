package Negocio;

import Dados.CursoRepositorio;
import Exception.CampoVazioException;
import Negocio.Entidades.Curso;

public class CursoControle {
	private CursoRepositorio cp;

	public CursoControle() {
		cp = new CursoRepositorio();
	}


	public CursoRepositorio getCp() {
		return cp;
	}



	public void setCp(CursoRepositorio cp) {
		this.cp = cp;
	}


	//BUSCAR O CODIGO PELO NOME DO CURSO
	public int buscarCodigo(String curso) {
		Curso c = new Curso (curso,"","");
		buscarCurso(c);

		return cp.getCursosLista().get(0).getCodigo();
	}
	//CONTROLA A STRING DE INSERT PARA CHAMAR O REPOSITORIO
	public void inserirCurso(Curso curso) throws CampoVazioException {
		String sql = "INSERT INTO curso(nome";
		String auxSQL = "VALUES (";

		if(curso.getNome() != null && !(curso.getNome().trim().equals(""))) {
			auxSQL += "'" + curso.getNome() + "'";
			if(curso.getHorario_funcionamento() != null && !(curso.getHorario_funcionamento().trim().equals(""))) {
				sql += ",hora_funcionamento";
				auxSQL +=  ",'" + curso.getHorario_funcionamento() + "'" ;
			}
			if(curso.getCpf_coordenador() != null && !(curso.getCpf_coordenador().trim().equals(""))) {
				sql += ",cpf_coordenador";
				auxSQL += ",'" + curso.getCpf_coordenador() + "'";
			}else {
				throw new CampoVazioException();
			}
			sql += ")" + auxSQL + ")";
			
			cp.inserirCurso(sql);
		
		}else {
			throw new CampoVazioException();
		}


		
	}
	//CONTROLA A STRING DE SELECT PARA CHAMAR O REPOSITORIO
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
		if(curso.getNome() != null && !(curso.getNome().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "nome = '" + curso.getNome() + "'";
				aux = 1;
			}else {
				sql += " AND " + " nome = '" + curso.getNome() + "'";
			}
		}
		if(curso.getCpf_coordenador() != null && !(curso.getCpf_coordenador().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "cpf_coordenador = '" + curso.getCpf_coordenador() + "'";
				aux = 1;
			}else {
				sql += " AND " + "cpf_coordenador = '" + curso.getCpf_coordenador() + "'";
			}
		}
		if(curso.getHorario_funcionamento() != null && !(curso.getHorario_funcionamento().trim().equals(""))) {
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
	//CONTROLA A STRING DE UPTADE PARA CHAMAR O REPOSITORIO
	public void inativarCurso(String curso) {
		int codigo =  buscarCodigo(curso);

		String sql = "UPDATE curso SET ativo = 'N' WHERE codigo = " + codigo;

		cp.inativarCurso(sql);
	}
	//CONTROLA A STRING DE UPTADE PARA CHAMAR O REPOSITORIO
	public void atualizarCurso(Curso novoCurso, String nomeCurso) {
		int aux = 0;
		String sql = "UPDATE curso SET ";
		
		int codigo = buscarCodigo(nomeCurso);
		String auxSQL = " WHERE codigo = " + codigo;
		
		if (novoCurso.getNome() != null && !(novoCurso.getNome().trim().equals(""))) {
			sql += "nome = '" + novoCurso.getNome();
			aux = 1;
		}
		if(novoCurso.getHorario_funcionamento() != null && !(novoCurso.getHorario_funcionamento().trim().equals(""))) {
			if(aux == 0) {
				sql += "hora_funcionamento = '" + novoCurso.getHorario_funcionamento();
				aux = 1;
			}else {
				sql += ",hora_funcionamento = '" + novoCurso.getHorario_funcionamento();
			}

		}
		if(novoCurso.getCpf_coordenador() != null && !(novoCurso.getCpf_coordenador().trim().equals(""))) {
			if(aux == 0) {
				sql += " cpf_coordenador = '" + novoCurso.getCpf_coordenador() + "'";
				aux = 1;
			}else {
				sql += ",cpf_coordenador = '" + novoCurso.getCpf_coordenador() + "'";
			}
			
		}
		sql += auxSQL;
		
		if(aux == 1)
		cp.atualizarCurso(sql);

	}
}

