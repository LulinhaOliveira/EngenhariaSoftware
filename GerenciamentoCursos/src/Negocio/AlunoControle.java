package Negocio;

import Dados.AlunoRepositorio;
import Exception.CampoVazioException;
import Negocio.Entidades.Aluno;

public class AlunoControle {
	private AlunoRepositorio ar;

	public AlunoControle() {
		ar = new AlunoRepositorio();
	}

	public AlunoRepositorio getAr() {
		return ar;
	}

	public void setAr(AlunoRepositorio ar) {
		this.ar = ar;
	}

	public void inserirAluno(Aluno a) throws CampoVazioException {
		String sql = "INSERT INTO aluno (cpf ";
		String auxSQL = "VALUES (";

		if(a.getCpf() != null && !(a.getCpf().trim().equals(""))) {
			auxSQL += "'" + a.getCpf() + "'";

			if(a.getData_início() != null && a.getData_início().trim().equals("")) {
				sql += ",data_inicio";
				auxSQL +=  ",'" + a.getData_início() + "'" ;

				if(a.getCodigo_curso() != 0 ) {
					sql += ",codigo_curso";
					auxSQL += ",'" + a.getCodigo_curso() + "'";

					if(a.getNumero_matricula() != null && !(a.getNumero_matricula().trim().equals(""))) {
						sql += ",numero_matricula";
						auxSQL += ",'" + a.getNumero_matricula() + "'";
					}

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

		ar.inserirAluno(sql);
	}

	public void buscarAlunos(Aluno a) {
		String sql = "SELECT * FROM aluno";
		String auxSQL = " WHERE ";
		int aux = 0;


		if( a.getCpf() != null && !(a.getCpf().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "cpf = '" + a.getCpf() + "'";
				aux = 1;
			}else {
				sql += " AND " + " cpf = '" + a.getCpf() + "'";
			}
		}
		if(a.getData_início() != null && !(a.getData_início().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "data_inicio = '" + a.getData_início()  + "'";
				aux = 1;
			}else {
				sql += " AND " + "data_inicio = '" + a.getData_início()  + "'";
			}
		}
		if(a.getNumero_matricula() != null && !(a.getNumero_matricula().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "numero_matricula = '" + a.getNumero_matricula() + "'";
				aux = 1;
			}else {
				sql += " AND " + "numero_matricula = '" + a.getNumero_matricula() + "'";
			}
		}

		if(a.getCodigo_curso() != 0) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "codigo_curso = '" + a.getCodigo_curso() + "'";
				aux = 1;
			}else {
				sql += "AND" + "codigo_curso = '" + a.getCodigo_curso() + "'";
			}
		}
		if(a.getAtivo() == 'N' || a.getAtivo() == 'S') {
			if(aux == 0) {
				sql += auxSQL;
				sql += "ativo = '" + a.getAtivo() + "'";
			}else {
				sql += " AND " + "ativo = '" + a.getAtivo() + "'";
			}
		}
		
		ar.buscarAlunos(sql);

	}

	public boolean isAluno(String cpf) {
		Aluno a =  new Aluno(cpf,"",0,"",'W');

		buscarAlunos(a);

		if(ar.getAlunoslista().size() > 0 ) {
			return true;
		}

		return false;
	}
}
