package Negocio;

import Dados.Oferta_DisciplinaRepositorio;
import Exception.CampoVazioException;
import Negocio.Entidades.Oferta_Disciplina;

public class Oferta_DisciplinaControle {
	private Oferta_DisciplinaRepositorio od;

	public Oferta_DisciplinaControle(){
		od = new Oferta_DisciplinaRepositorio();
	}

	public Oferta_DisciplinaRepositorio getOd() {
		return od;
	}

	public void setOd(Oferta_DisciplinaRepositorio od) {
		this.od = od;
	}
	
	
	public void inserirOferta_Disciplina(Oferta_Disciplina o) throws CampoVazioException {
		String sql = "INSERT INTO oferta_disciplina(codigo,dia_1";
		String auxSQL = "VALUES (";
		
		auxSQL += "'" + o.getCodigo() + "'";
		if(o.getDia_1() != null && !(o.getDia_1().trim().equals(""))) {
			auxSQL += ",'" + o.getDia_1() + "'";

			if(o.getDia_2() != null && !(o.getDia_2().trim().equals(""))) {
				sql += ",dia_2";
				auxSQL +=  ",'" + o.getDia_2() + "'" ;

				if(o.getHora_1() != null && !o.getHora_1().trim().equals("")) {
					sql += ",hora_1";
					auxSQL += ",'" + o.getHora_1() + "'";

					if(o.getHora_2() !=  null && !o.getHora_2().trim().equals("")) {
						sql += ",hora_2";
						auxSQL += ",'" + o.getHora_2() + "'";
						
						if(o.getCpf() != null && !(o.getCpf().trim().equals(""))) {
							sql += ",cpf";
							auxSQL += ",'" + o.getCpf() + "'";
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

		}else {
			throw new CampoVazioException();
		}
		
		sql += ")" + auxSQL + ")";
		
		
		od.inserirOferta_Disciplina(sql);
	}

	public void atualizarOferta_Disciplina(Oferta_Disciplina o , int codigo_Oferta) {
		int aux = 0;
		String sql = "";


		if (o.getDia_1()!= null && !(o.getDia_1().trim().equals(""))) {
			sql += "UPDATE oferta_disciplina SET dia_1 = '" + o.getDia_1()  +"' WHERE codigo = " + codigo_Oferta + ";"; 
			aux = 1;
		}
		if(o.getDia_2() != null && !(o.getDia_2().trim().equals(""))) {
			sql += "UPDATE oferta_disciplina SET dia_2 = '" + o.getDia_2()  +"' WHERE codigo = " + codigo_Oferta + ";"; 
			aux = 1;

		}
		if(o.getHora_1() != null && !o.getHora_1().trim().equals("")) {
			sql += "UPDATE oferta_disciplina SET hora_1 = '" + o.getHora_1() != 0 + "' WHERE codigo = " + codigo_Oferta + ";";
			aux = 1;
		}
		
		if(o.getHora_2() !=  null && !o.getHora_2().trim().equals("")) {
			sql += "UPDATE oferta_disciplina SET hora_2 = '" + o.getHora_2() != 0 + "' WHERE codigo = " + codigo_Oferta + ";";
			aux = 1;
		}
		
		if(o.getCpf() != null && !(o.getCpf()).trim().equals("")){
			sql += "UPDATE oferta_disciplina SET cpf = '" + o.getCpf() != 0 + "' WHERE codigo = " + codigo_Oferta + ";";
			aux = 1;
		}
		
		if(aux == 1) {
			od.atualizarOferta_Disciplina(sql);
		}
	}
	
	public void inativarOferta_Disciplina(int codigo) {
		String sql = "UPDATE oferta_disciplina SET ativo = 'N' WHERE codigo = " + codigo;
		
		od.inativarOferta_Disciplina(sql);
	}

	public void buscarOferta_Disciplina(Oferta_Disciplina o, int codigo_curso) {
		String sql = "SELECT * FROM oferta_disciplina";
		String auxSQL = " WHERE ";
		int aux = 0;

		
		
		if(o.getCodigo() != 0) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "codigo = " + o.getCodigo();
				aux = 1;
			}
		}
		if(o.getDia_1() != null && !(o.getDia_1().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "dia_1 = '" + o.getDia_1() + "'";
				aux = 1;
			}else {
				sql += " AND " + " dia_1 = '" + o.getDia_1() + "'";
			}
		}
		if(o.getDia_2() != null && !(o.getDia_2() .trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "dia_2 = '" + o.getDia_2()  + "'";
				aux = 1;
			}else {
				sql += " AND " + "dia_2 = '" + o.getDia_2()  + "'";
			}
		}
		if(o.getHora_1() !=  null && !o.getHora_1().trim().equals("")) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "hora_1 = '" + o.getHora_1() + "'";
				aux = 1;
			}else {
				sql += " AND " + "hora_1 = '" + o.getHora_1() + "'";
			}
		}

		if(o.getHora_2() !=  null && !o.getHora_2().trim().equals("")) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "hora_2 = '" + o.getHora_2() + "'";
				aux = 1;
			}else {
				sql += "AND" + "hora_2 = '" + o.getHora_2() + "'";
			}
		}
		if(o.getAtivo() == 'N' || o.getAtivo() == 'S') {
			if(aux == 0) {
				sql += auxSQL;
				sql += "ativo = '" + o.getAtivo() + "'";
			}else {
				sql += " AND " + "ativo = '" + o.getAtivo() + "'";
			}
		}
		if(o.getCpf() != null && !(o.getCpf().trim().equals(""))) {
			if(aux == 0) {
				sql += auxSQL;
				sql += "cpf = '" + o.getCpf() + "'";
			}else {
				sql += " AND " + "cpf = '" + o.getCpf() + "'";
			}
		}

		od.disciplinasOfertadas(sql);
	}

}
