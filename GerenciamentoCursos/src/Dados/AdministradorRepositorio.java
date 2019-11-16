package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancoDados.Conexao;
import Negocio.Entidades.Administrador;

public class AdministradorRepositorio {
	private ArrayList <Administrador> administradorlista;
	private Administrador administrador;

	public AdministradorRepositorio(){
		administradorlista = new ArrayList <Administrador> ();
	}
	
	public ArrayList<Administrador> getAdministradorlista() {
		return administradorlista;
	}

	public void setAdministradorlista(ArrayList<Administrador> administradorlista) {
		this.administradorlista = administradorlista;
	}



	public void inserirAdministrador(String sql) {
		int rowInsered = Conexao.getInstance().executaSQL(sql);
		if(rowInsered == 200) {
			JOptionPane.showMessageDialog(null, "Administrador Inserido Com Sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao Inserir Administrador");
		}
	}

	public void buscarAdministrador(String sql) {
		administradorlista.clear();

		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				administrador = new Administrador(Conexao.getInstance().getResultset().getString("cpf"));
				administradorlista.add(administrador);
			}

		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);
	}

}
