package Negocio;

import Dados.AdministradorRepositorio;
import Exception.CampoVazioException;
import Negocio.Entidades.Administrador;

public class AdministradorControle {
	private AdministradorRepositorio ar;

	public AdministradorControle() {
		ar = new AdministradorRepositorio();
	}

	public AdministradorRepositorio getCp() {
		return ar;
	}

	public void setCp(AdministradorRepositorio ar) {
		this.ar = ar;
	}


	public void inserirAdministrador(Administrador a) throws CampoVazioException {
		String sql = "INSERT INTO administrador (cpf ";
		String auxSQL = "VALUES (";

		if(a.getCpf() != null && !(a.getCpf().trim().equals(""))) {
			auxSQL += "'" + a.getCpf() + "'";

		}else {
			throw new CampoVazioException();
		}

		sql += ")" + auxSQL + ")";

		ar.inserirAdministrador(sql);
	}

	public void buscarAdministradores(Administrador a) {
		String sql = "SELECT * FROM administrador";
		String auxSQL = " WHERE ";

		if( a.getCpf() != null && !(a.getCpf().trim().equals(""))) {
			sql += auxSQL;
			sql += "cpf = '" + a.getCpf() + "'";	

		}
		ar.buscarAdministrador(sql);
	}
	
	public boolean isAdministrador(String cpf) {
		Administrador a = new Administrador(cpf);
		
		buscarAdministradores(a);
		
		if(ar.getAdministradorlista().size() > 0 ) {
			return true;
		}
		
		return false;
	}
}
