package Negocio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Dados.UsuarioRepositorio;

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

}
