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


	public ArrayList<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}


	public UsuarioRepositorio(){
		listaUsuario = new ArrayList <Usuario> ();
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
			for (Usuario user: listaUsuario) {
				System.out.println(user.getNome());
			}
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
					System.out.println(this.usuario.getNome());
					Conexao.getInstance().setResultset(null);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inserirUsuario(ArrayList<Object> data) {
		try {
			//recebe o ultimo campo do arrayList
			Object o = data.get(data.size() - 1);

			String sql = "INSERT INTO usuario(cpf, nome, sexo, telefone, email, senha) VALUES (";
			for (Object obj: data) {
				if (obj == null) {
					JOptionPane.showMessageDialog(null, "Par�metros incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
				} else if(o != obj) {
					if (obj instanceof Character) {
						//tipo char concatena com aspas simples
						sql += "\'" + obj + "\', "; 
					} else {
						sql += "\"" + obj + "\", "; 
					}
				} else if (o == obj) {
					//caso entre aqui, ser� o ultimo dado do arraylist, ent�o n�o precisa concatenar a ','
					sql += "\"" + obj +"\"";	
				}
			}
			sql += ");";

			int rowInsered = Conexao.getInstance().executaSQL(sql);
			if (rowInsered == 200) {
				JOptionPane.showMessageDialog(null, "Usu�rio inserido com sucesso");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizarUsuario(String cpf, String nome, String telefone, String email, String senha) {
		try {
			if (cpf != null &&  cpf.isEmpty()) {
				String sql = "UPDATE usuario SET";
				int aux = 0;
				if (nome != null && !nome.isEmpty()) {
					sql += " nome = '" + nome + "'";
					aux = 1;
				}

				if (telefone != null && !telefone.isEmpty()) {
					if (aux == 1) {
						sql += ", telefone = '" + telefone + "'";
					} else {
						aux = 1;
						sql += " telefone = '" + telefone + "'";
					}
				}

				if (email != null && !email.isEmpty()) {
					if (aux == 1) {
						sql += ", email = '" + email + "'";
					} else {
						sql += " email = '" + email + "'";
					}
				}

				sql += " WHERE cpf = '" + cpf + "'";

				int rowInsered = Conexao.getInstance().executaSQL(sql);
				if (rowInsered == 200) {
					JOptionPane.showMessageDialog(null, "Usu�rio atualizado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Par�metros incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void desativarUsuario(String cpf) {
		try {
			if (cpf != null && !cpf.isEmpty()) {
				String sql = "UPDATE usuario SET ativo = 'N' WHERE cpf = '" + cpf + "'";
				
				int rowInsered = Conexao.getInstance().executaSQL(sql);
				
				if (rowInsered == 200) {
					JOptionPane.showMessageDialog(null, "Usu�rio desativado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Par�metros incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}catch (Exception e) {
			
		}
	}
}
