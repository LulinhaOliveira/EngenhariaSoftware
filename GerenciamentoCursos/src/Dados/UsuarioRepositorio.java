package Dados;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancoDados.Conexao;

import Negocio.Entidades.Usuario;

public class UsuarioRepositorio {
	private ArrayList <Usuario> listaUsuario;
	Usuario usuario;

	public UsuarioRepositorio() {
		listaUsuario = new ArrayList <Usuario>();
	}

	public ArrayList<Usuario> getListaUsuario() {
		if (this.listaUsuario != null) {
			return listaUsuario;
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum dado encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
		if (listaUsuario != null) {
			this.listaUsuario = listaUsuario;
		} else {
			JOptionPane.showMessageDialog(null, "Parametros incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void encontrarTodosUsuarios() {
		listaUsuario.clear();
		String sql = "SELECT * FROM usuario WHERE ativo = 'S'";
		Conexao.getInstance().buscarSQL(sql);

		try {
			while (Conexao.getInstance().getResultset().next()) {
				usuario = new Usuario(Conexao.getInstance().getResultset().getString("cpf"), Conexao.getInstance().getResultset().getString("nome"),
						Conexao.getInstance().getResultset().getString("email"), Conexao.getInstance().getResultset().getString("sexo").charAt(0), 
						Conexao.getInstance().getResultset().getString("telefone"),
						Conexao.getInstance().getResultset().getString("senha"),
						Conexao.getInstance().getResultset().getString("ativo").charAt(0));
				listaUsuario.add(usuario);
			}
			Conexao.getInstance().setResultset(null);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void encontrarUsuario(String cpf) {
		try {
			if (cpf != null && !cpf.isEmpty()) {
				listaUsuario.clear();
				String sql = "SELECT * FROM usuario WHERE cpf = "+cpf;
				Conexao.getInstance().buscarSQL(sql);
				while (Conexao.getInstance().getResultset().next()) {
					usuario = new Usuario(Conexao.getInstance().getResultset().getString("cpf"), Conexao.getInstance().getResultset().getString("nome"),
							Conexao.getInstance().getResultset().getString("email"), Conexao.getInstance().getResultset().getString("sexo").charAt(0), 
							Conexao.getInstance().getResultset().getString("telefone"),
							Conexao.getInstance().getResultset().getString("senha"),
							Conexao.getInstance().getResultset().getString("ativo").charAt(0));
					listaUsuario.add(usuario);
					Conexao.getInstance().setResultset(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Parametros incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inserirUsuario(String sql) {
		try {
			int rowInsered = Conexao.getInstance().executaSQL(sql);
			if (rowInsered == 200) {
				JOptionPane.showMessageDialog(null, "Usuario inserido com sucesso");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizarUsuario(String sql) {
		try {
			int rowInsered = Conexao.getInstance().executaSQL(sql);
			if (rowInsered == 200) {
				JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "Parametros incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void desativarUsuario(String sql) {
		try {
			int rowInsered = Conexao.getInstance().executaSQL(sql);
				
			if (rowInsered == 200) {
				JOptionPane.showMessageDialog(null, "Usuario desativado com sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "Parametros incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}catch (Exception e) {
			
		}
	}
}
