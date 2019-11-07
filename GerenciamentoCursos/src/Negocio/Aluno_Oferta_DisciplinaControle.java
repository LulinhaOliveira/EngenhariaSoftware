package Negocio;

import Dados.Aluno_Oferta_DisciplinaRepositorio;
import Exception.CampoVazioException;
import Negocio.Entidades.Aluno_Oferta_Disciplina;

public class Aluno_Oferta_DisciplinaControle {
	private Aluno_Oferta_DisciplinaRepositorio aod;

	public Aluno_Oferta_DisciplinaControle() {
		aod = new Aluno_Oferta_DisciplinaRepositorio();
	}

	public Aluno_Oferta_DisciplinaRepositorio getAod() {
		return aod;
	}

	public void setAod(Aluno_Oferta_DisciplinaRepositorio aod) {
		this.aod = aod;
	}

	public void inserirAluno_Disciplina(Aluno_Oferta_Disciplina a) throws CampoVazioException {
		String sql = "INSERT INTO aluno_oferta_disciplina(cpf";
		String auxSQL = "VALUES (";

		if(a.getCpf() != null && !(a.getCpf().trim().equals(""))) {
			auxSQL += "'" + a.getCpf() + "'";

			if(a.getCodigo() != 0 ) {
				sql += ",codigo";
				auxSQL += "'" + a.getCodigo() + "'";

				sql += ",nota_1";
				auxSQL +=  ",'" + a.getNota_1() + "'" ;


				sql += ",nota_2";
				auxSQL += ",'" + a.getNota_2() + "'";


				sql += ",media_final";
				auxSQL += ",'" + a.getMedia_final() + "'";

				sql += ",frequencia";
				auxSQL += ",'" + a.getFrequencia() + "'";

				if(a.getCpf() != null && !(a.getCpf().trim().equals(""))) {
					sql += ",cpf";
					auxSQL += ",'" + a.getCpf() + "'";
				}else {
					throw new CampoVazioException();
				}
			}else {
				throw new CampoVazioException();
			}
		}else {
			throw new CampoVazioException();
		}

		sql += ")" + auxSQL + ")";
		
		aod.inserirAluno_Oferta(sql);

	}

	public void alterarStatus(Aluno_Oferta_Disciplina a) {
		String sql = "UPTADE aluno_oferta_disciplina SET ativo = ";
		a.setMedia_final((a.getNota_1() + a.getNota_2()) / 2);
		if(a.getMedia_final() >= 7) {
			sql += "'Aprovado'";
		}else {
			sql += "'Reprovado'";
		}
		
		sql += ", media_final = " + a.getMedia_final() + "WHERE aluno_oferta_disciplina.cpf = '" + a.getCpf() + "'" ;
		
		aod.alterarStatus(sql);
	}

	
	public void atribuirNota_1(double nota, String cpf) {
		String sql = "UPDATE aluno_oferta_disciplina SET nota_1 = '" + nota +"' WHERE cpf = " + cpf + ";";
		
		aod.atualizarAluno_Disciplina(sql);
	}
	
	public void atribuirNota_2(double nota, String cpf) {
		String sql = "UPDATE aluno_oferta_disciplina SET nota_2 = '" + nota +"' WHERE cpf = " + cpf + ";";
		
		aod.atualizarAluno_Disciplina(sql);
	}
	public void atribuirFrequencia (String cpf) {
		String sql = "UPDATE aluno_oferta_disciplina SET frequencia = frequencia + 1" + " WHERE cpf = " + cpf + ";";
		
		aod.atualizarAluno_Disciplina(sql);
	}
	
	public void buscarAluno_Disciplina(Aluno_Oferta_Disciplina a) {
		String sql = "SELECT * FROM curso";
		String auxSQL = " WHERE ";
		int aux = 0;

		if(a.getCpf() != null && a.getCpf().trim().equals("")) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "cpf = " + a.getCpf();
				aux = 1;
			}
		}
		if(a.getCodigo() != 0) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "codigo = '" + a.getCodigo() + "'";
				aux = 1;
			}else {
				sql += " AND " + " nome = '" + a.getCodigo() + "'";
			}
			
			aod.buscarAluno_Disciplina(sql);
		}
	}
}
