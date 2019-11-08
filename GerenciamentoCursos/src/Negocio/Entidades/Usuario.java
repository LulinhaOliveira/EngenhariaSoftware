package Negocio.Entidades;

public class Usuario {
	private String cpf; 
	private String nome;
	private String email; 
	private char sexo;  
	private String telefone; 
	private char ativo;
	private String senha;
	
	public Usuario(String cpf, String nome, String email, char sexo, String telefone, String senha, char ativo) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.telefone = telefone;
		this.senha = senha;
		this.ativo = ativo;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String toString() {
		return "Nome: " + this.nome + "\nEmail: " +this.email + "\nTelefone: " + this.telefone + 
				"\nSexo: " + this.sexo;
	}
}
