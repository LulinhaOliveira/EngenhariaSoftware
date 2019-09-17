package Negocio.Entidades;

public class Administrador {
	private String cpf;

	public Administrador(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	} 
}
