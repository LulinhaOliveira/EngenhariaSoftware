package Negocio;

import java.sql.SQLException;

import BancoDados.Conexao;
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
	
	public int pegarCodigoTurma(int codigo) {
		String sql = "SELECT * FROM disciplina WHERE codigo = '" + codigo + "'";
		int codigo_turma = -1;
		
		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				codigo_turma = Integer.parseInt(Conexao.getInstance().getResultset().getString("codigo_turma"));
			}
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Conexao.getInstance().setResultset(null);
		return codigo_turma;
	}
	
	public void inserirAluno_Disciplina(Aluno_Oferta_Disciplina a) throws CampoVazioException {
		String sql = "INSERT INTO aluno_oferta_disciplina(cpf";
		String auxSQL = "VALUES (";
		
		if(a.getCpf() != null && !(a.getCpf().trim().equals(""))) {
			auxSQL += "'" + a.getCpf() + "'";

			if(a.getCodigo() != 0 ) {
				sql += ",codigo";
				auxSQL += "," + a.getCodigo() + "";

				sql += ",nota_1";
				auxSQL +=  "," + a.getNota_1() ;


				sql += ",nota_2";
				auxSQL += "," + a.getNota_2();


				sql += ",media_final";
				auxSQL += "," + a.getMedia_final() ;

				sql += ",frequencia";
				auxSQL += "," + a.getFrequencia();

			}else {
				throw new CampoVazioException();
			}
		}else {
			throw new CampoVazioException();
		}
		sql += ")" + auxSQL + ")";
	
		aod.inserirAluno_Oferta(sql);

	}
	
	public void definirMedia(Aluno_Oferta_Disciplina a) {
		String sql = "UPDATE aluno_oferta_disciplina SET media_final = ";
		a.setMedia_final((a.getNota_1() + a.getNota_2()) / 2);
		sql += a.getMedia_final();
		sql += " WHERE cpf = " + a.getCpf() + " AND codigo = " + a.getCodigo();
		aod.atualizarAluno_Disciplina(sql);
	}
	public void alterarStatus(Aluno_Oferta_Disciplina a) {
		
		String sql = "UPDATE aluno_oferta_disciplina SET ativo = ";
		if(a.getMedia_final() >= 7) {
			sql += "'Aprovado'";
		}else {
			sql += "'Reprovado' 	";
		}
		
		sql += " WHERE aluno_oferta_disciplina.cpf = '" + a.getCpf() + "'AND codigo = " + a.getCodigo() ;
		
		aod.alterarStatus(sql);
	}

	
	public void atribuirNota_1(double nota, String cpf, int codigo) {
		String sql = "UPDATE aluno_oferta_disciplina SET aluno_oferta_disciplina.nota_1 = '" + nota +"' WHERE aluno_oferta_disciplina.cpf = '" + cpf + "' AND aluno_oferta_disciplina.codigo = " + codigo;
		
		aod.atualizarAluno_Disciplina(sql);
	}
	
	public void atribuirNota_2(double nota, String cpf, int codigo) {
		String sql = "UPDATE aluno_oferta_disciplina SET aluno_oferta_disciplina.nota_2 = '" + nota +"' WHERE aluno_oferta_disciplina.cpf = '" + cpf + "' AND aluno_oferta_disciplina.codigo = " + codigo;
		aod.atualizarAluno_Disciplina(sql);
	}
	public void atribuirFrequencia (String cpf, int codigo) {
		String sql = "UPDATE aluno_oferta_disciplina SET aluno_oferta_disciplina.frequencia = aluno_oferta_disciplina.frequencia + 1" + " WHERE aluno_oferta_disciplina.cpf ='" + cpf + "' AND aluno_oferta_disciplina.codigo = " + codigo;
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
