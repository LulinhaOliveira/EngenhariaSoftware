package Negocio;

import Dados.CoordenadorRepositorio;
import Exception.CampoVazioException;
import Negocio.Entidades.Coordenador;

public class CoordenadorControle {
	private CoordenadorRepositorio cp;

	public CoordenadorControle() {
		cp = new CoordenadorRepositorio();
	}

	public CoordenadorRepositorio getCp() {
		return cp;
	}

	public void setCp(CoordenadorRepositorio cp) {
		this.cp = cp;
	}


	public void inserirCoordenador(Coordenador c) throws CampoVazioException {
		String sql = "INSERT INTO coordenador (cpf ";
		String auxSQL = "VALUES (";
		
		if(c.getCpf() != null && !(c.getCpf().trim().equals(""))) {
			auxSQL += "'" + c.getCpf() + "'";

		}else {
			throw new CampoVazioException();
		}

		sql += ")" + auxSQL + ")";
		
		cp.inserirCoordenador(sql);
	}
	
	public void buscarCoordenadores(Coordenador c) {
		String sql = "SELECT * FROM coordenador";
		String auxSQL = " WHERE ";
	


		if( c.getCpf() != null && !(c.getCpf().trim().equals(""))) {
				sql += auxSQL;
				sql += "cpf = '" + c.getCpf() + "'";	

		}

	
		cp.buscarCoordenador(sql);
	
	}
}
