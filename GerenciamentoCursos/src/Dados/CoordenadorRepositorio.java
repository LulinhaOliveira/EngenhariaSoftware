package Dados;

import java.sql.SQLException;
import java.util.ArrayList;
import BancoDados.Conexao;
import Negocio.Entidades.Coordenador;

public class CoordenadorRepositorio {
	private ArrayList <Coordenador> coordenadoreslista;
	private Coordenador coordenador;

	public CoordenadorRepositorio(){
		coordenadoreslista = new ArrayList <Coordenador> ();
	}

	public ArrayList<Coordenador> getCoordenadoreslista() {
		return coordenadoreslista;
	}

	public void setCoordenadoreslista(ArrayList<Coordenador> coordenadoreslista) {
		this.coordenadoreslista = coordenadoreslista;
	}

	public void inserirCoordenador(String sql) {
		Conexao.getInstance().executaSQL(sql);
	}

	public void buscarCoordenador(String sql) {
		coordenadoreslista.clear();

		Conexao.getInstance().buscarSQL(sql);
		try {
			while(Conexao.getInstance().getResultset().next()) {
				coordenador = new Coordenador(Conexao.getInstance().getResultset().getString("cpf"));
				coordenadoreslista.add(coordenador);
			}

		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexao.getInstance().setResultset(null);
	}

}
