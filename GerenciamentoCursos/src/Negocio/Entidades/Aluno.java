package Negocio.Entidades;

import java.sql.Date;

public class Aluno {
	private String cpf; 
	private Date data_in�cio; 
	private int codigo_curso;
	private String numero_matricula; 
    private char ativo;
	
    public String getCpf() {
		return cpf;
	}
	public Aluno(String cpf, Date data_in�cio, int codigo_curso, String numero_matricula, char ativo) {
		this.cpf = cpf;
		this.data_in�cio = data_in�cio;
		this.codigo_curso = codigo_curso;
		this.numero_matricula = numero_matricula;
		this.ativo = ativo;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getData_in�cio() {
		return data_in�cio;
	}
	public void setData_in�cio(Date data_in�cio) {
		this.data_in�cio = data_in�cio;
	}
	public int getCodigo_curso() {
		return codigo_curso;
	}
	public void setCodigo_curso(int codigo_curso) {
		this.codigo_curso = codigo_curso;
	}
	public String getNumero_matricula() {
		return numero_matricula;
	}
	public void setNumero_matricula(String numero_matricula) {
		this.numero_matricula = numero_matricula;
	}
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
}
