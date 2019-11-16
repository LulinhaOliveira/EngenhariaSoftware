package Negocio;

import Dados.TurmaRepositorio;
import Exception.CampoVazioException;
import Negocio.Entidades.Turma;


public class TurmaControle {

	private TurmaRepositorio tp;

	public TurmaControle (){
		tp = new TurmaRepositorio();
	}
	
	public TurmaRepositorio getTp() {
		return tp;
	}



	public void setTp(TurmaRepositorio tp) {
		this.tp = tp;
	}

	//BUSCAR O CODIGO PELO NOME DA TURMA
	public int buscarCodigo(String turma) {
		Turma t = new Turma (turma,"","","");
		buscarTurma(t);

		return tp.getTurmalista().get(0).getCodigo();
	}
	//CONTROLA A STRING DE INSERT PARA CHAMAR O REPOSITORIO
	public void inserirTurma(Turma turma) throws CampoVazioException {
		String sql = "INSERT INTO turma(nome";
		String auxSQL = "VALUES (";

		if(turma.getNome() != null && !(turma.getNome().trim().equals(""))) {
			auxSQL += "'" + turma.getNome() + "'";

			if(turma.getSigla() != null && !(turma.getSigla().trim().equals(""))) {
				sql += ",sigla";
				auxSQL +=  ",'" + turma.getSigla() + "'" ;

				if(turma.getTurno() != null && !(turma.getTurno().trim().equals(""))) {
					sql += ",turno";
					auxSQL += ",'" +turma.getTurno() + "'";

					if(turma.getSemestre() != null && !(turma.getSemestre().trim().equals(""))) {
						sql += ",semestre";
						auxSQL += ",'" + turma.getSemestre() + "'";
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

		tp.inserirTurma(sql);

	}
	//CONTROLA A STRING DE SELECT PARA CHAMAR O REPOSITORIO
	public void buscarTurma(Turma turma) {
		String sql = "SELECT * FROM turma";
		String auxSQL = " WHERE ";
		int aux = 0;

		if(turma.getCodigo() != 0) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "codigo = " + turma.getCodigo();
				aux = 1;
			}
		}
		if(turma.getNome() != null && !(turma.getNome().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "nome = '" + turma.getNome() + "'";
				aux = 1;
			}else {
				sql += " AND " + " nome = '" + turma.getNome() + "'";
			}
		}
		if(turma.getSigla() != null && !(turma.getSigla() .trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "sigla = '" + turma.getSigla()  + "'";
				aux = 1;
			}else {
				sql += " AND " + "sigla = '" + turma.getSigla()  + "'";
			}
		}
		if(turma.getTurno() != null && !(turma.getTurno().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "turno = '" + turma.getTurno() + "'";
				aux = 1;
			}else {
				sql += " AND " + "turno = '" + turma.getTurno() + "'";
			}
		}

		if(turma.getSemestre() != null && !(turma.getSemestre().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "semestre = '" + turma.getSemestre() + "'";
				aux = 1;
			}else {
				sql += "AND" + "semestre = '" + turma.getSemestre() + "'";
			}
		}
		if(turma.getAtivo() == 'N' || turma.getAtivo() == 'S') {
			if(aux == 0) {
				sql += auxSQL;
				sql += "ativo = '" + turma.getAtivo() + "'";
			}else {
				sql += " AND " + "ativo = '" + turma.getAtivo() + "'";
			}
		}

		tp.buscarTurma(sql);
	}

	//CONTROLA A STRING DE UPTADE PARA CHAMAR O REPOSITORIO
	public void inativarTurma(String turma) {

		int codigo = buscarCodigo(turma);

		String sql = "UPDATE turma SET ativo = 'N' WHERE codigo = " + codigo;

		tp.inativarTurma(sql);
	}

	public void atualizarTurma(Turma novaTurma, String nomeTurma) {

		int aux = 0;
		String sql = "UPDATE turma SET ";
		int codigo = buscarCodigo(nomeTurma);
		String auxSQL = " WHERE codigo = " + codigo;
		
		if (novaTurma.getNome() != null && !(novaTurma.getNome().trim().equals(""))) {
			sql += "nome = '" + novaTurma.getNome()  + "'"; 
			aux = 1;
		}
		if(novaTurma.getSigla() != null && !(novaTurma.getSigla().trim().equals(""))) {
			if(aux == 0) {
				sql += " sigla = '" + novaTurma.getSigla() + "'"; 
				aux = 1;
			}else {
				sql += " ,sigla = '" + novaTurma.getSigla() + "'"; 
			}
	

		}
		if(novaTurma.getTurno() != null && !(novaTurma.getTurno().trim().equals(""))) {
			if(aux == 0) {
				sql += " turno = '" + novaTurma.getTurno() + "'";
				aux = 1;
			}else {
				sql += " ,turno = '" + novaTurma.getTurno() + "'";
			}

		}
		
		if(novaTurma.getSemestre() != null && !(novaTurma.getSemestre().trim().equals(""))) {
			if(aux == 0) {
				sql += " semestre = '" + novaTurma.getSemestre() + "'";
				aux = 1;
			}else {
				sql += " ,semestre = '" + novaTurma.getSemestre() + "'";
			}
			
		}
		
		sql += auxSQL;
		if(aux == 1) {
			tp.atualizarTurma(sql);
		}
	}
}
