package Negocio;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Dados.UsuarioRepositorio;
import Exception.CPFException;
import Exception.NomeNumeroException;
import Exception.SenhaErradaException;
import Exception.SenhaPequenaException;
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
	
	public boolean validarSenha(String senha) {
		//verificar se existe um espaço na senha
		boolean encontrou_espaco = false;
		encontrou_espaco = senha.contains(" ");
		
		if (senha.isEmpty() || senha.length() < 6) {
			return false;
		}
		
		if (encontrou_espaco == true) {
			return false;
		}
		
		return true;
	}
	
	public boolean validarNome(String nome) {
		if (nome.isEmpty()) {
			return false;
		} else {
			//verificar se existe numeros no nome
			Pattern pattern = Pattern.compile("[0-9]");
			Matcher matcher = pattern.matcher(nome);
			if (matcher.find()) {
				return false;
			}
		}
		return true;
	}

	public boolean validarCPF(String cpf) {
		int i, j, digito2 = 0;

		if (cpf.length() != 11) {
			
			return false;
		} else if ((cpf == "00000000000") || (cpf == "11111111111") || (cpf == "22222222222") ||
				(cpf == "33333333333") || (cpf == "44444444444") || (cpf == "55555555555") ||
				(cpf == "66666666666") || (cpf == "77777777777") || (cpf == "88888888888") ||
				(cpf == "99999999999")) {
			
			return false;
		} else {
			for (i = 0, j = 11; i < cpf.length() - 1; i++, j--) {
				digito2 += (cpf.charAt(i) - 48) * j;
				digito2 *= 11;
			}
			if (digito2 < 2) {
				digito2 = 0;

			} else {
				digito2 = 11 - digito2;
			}
			return true;
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
	public void inserirUsuario(ArrayList<Object> data) throws CPFException, NomeNumeroException, SenhaPequenaException {
		if(validarCPF((String)data.get(0)) == true) {
			if(validarNome((String)data.get(1)) == true) {
				if(validarSenha((String)data.get(5)) == true) {
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
								
				}else {
					throw new SenhaPequenaException();
				}
			}else {
				throw new NomeNumeroException();
			}
		}else {
			throw new CPFException();
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
