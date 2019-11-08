package Negocio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Dados.UsuarioRepositorio;
import Exception.SenhaErradaException;
import Exception.cpfErradoException;
import Negocio.Entidades.Usuario;

public class UsuarioControle {
    private UsuarioRepositorio up;
    
    public UsuarioControle() {
        up = new UsuarioRepositorio();
    }

    public UsuarioRepositorio getUsuarioRepositorio() {
        if (this.up != null) {
            return this.up;             
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum dado encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
		return null;
    }

    public void setUsuarioRepositorio(UsuarioRepositorio up) {
        if (up != null) {
            this.up = up;
        } else {
            JOptionPane.showMessageDialog(null, "Parametros incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

public String buscarCodigo(String nome) {
		
		up.encontrarTodosUsuarios();
		
		for(Usuario u : up.getListaUsuario()) {
			if(u.getNome().equals(nome)){
				return u.getCpf();
			}
		}
		
		return "";
	}
    public void inserirUsuario(ArrayList<Object> data) {
        try {
			//recebe o ultimo campo do arrayList
			Object o = data.get(data.size() - 1);

			String sql = "INSERT INTO usuario(cpf, nome, sexo, telefone, email, senha) VALUES (";
			for (Object obj: data) {
				if (obj == null) {
					JOptionPane.showMessageDialog(null, "Parametros incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
				} else if(o != obj) {
					if (obj instanceof Character) {
						//tipo char concatena com aspas simples
						sql += "\'" + obj + "\', "; 
					} else {
						sql += "\"" + obj + "\", "; 
					}
				} else if (o == obj) {
					//caso entre aqui, sera o ultimo dado do arraylist, entao nao precisa concatenar a ','
					sql += "\"" + obj +"\"";	
				}
			}
			sql += ");";
            up.inserirUsuario(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void atualizarUsuario (String cpf, String nome, String telefone, String email, String senha) {
        try {
            if (cpf != null &&  !cpf.trim().equals("")) {
				String sql = "UPDATE usuario SET";
				int aux = 0;
				if (nome != null && !nome.trim().equals("")) {
					sql += " nome = '" + nome + "'";
					aux = 1;
				}

				if (telefone != null && !telefone.trim().equals("")) {
					if (aux == 1) {
						sql += ", telefone = '" + telefone + "'";
					} else {
						aux = 1;
						sql += " telefone = '" + telefone + "'";
					}
				}

				if (email != null && !email.trim().equals("")) {
					if (aux == 1) {
						sql += ", email = '" + email + "'";
					} else {
						sql += " email = '" + email + "'";
					}
				}
				if (senha != null && !senha.trim().equals("")) {
					if (aux == 1) {
						sql += ", senha = '" + senha + "'";
					} else {
						sql += " senha = '" + senha + "'";
					}
				}
				sql += " WHERE cpf = '" + cpf + "'";
                
				up.atualizarUsuario(sql);
            }
        } catch(Exception e) {
            // TODO Auto-generated catch block
			e.printStackTrace();
        }
    }

    public void desativarUsuario(String cpf) {
		try {
			if (cpf != null && !cpf.isEmpty()) {
				String sql = "UPDATE usuario SET ativo = 'N' WHERE cpf = '" + cpf + "'";
                up.desativarUsuario(sql);
			}
		}catch (Exception e) {
			
		}
	}
    
	public boolean fazerLogin(String cpf, String senha) throws SenhaErradaException, cpfErradoException {
		up.encontrarUsuario(cpf);
		
		if(up.getListaUsuario().size() > 0) {
			if(up.getListaUsuario().get(0).getSenha().equals(senha)) {
				return true;
			}else {
				throw new SenhaErradaException();
			}
		}else {
			throw new cpfErradoException();
		}
	}

}
