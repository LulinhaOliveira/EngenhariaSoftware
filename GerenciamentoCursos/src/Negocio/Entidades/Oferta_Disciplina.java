package Negocio.Entidades;

import java.sql.Time;

public class Oferta_Disciplina {
	private int codigo; 
	private String dia_1; 
	private String dia_2; 
	private Time hora_1; 
	
	public Oferta_Disciplina(int codigo, String dia_1, String dia_2, Time hora_1, Time hora_2, char ativo, String cpf) {
		this.codigo = codigo;
		this.dia_1 = dia_1;
		this.dia_2 = dia_2;
		this.hora_1 = hora_1;
		this.hora_2 = hora_2;
		this.ativo = ativo;
		this.cpf = cpf;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDia_1() {
		return dia_1;
	}
	public void setDia_1(String dia_1) {
		this.dia_1 = dia_1;
	}
	public String getDia_2() {
		return dia_2;
	}
	public void setDia_2(String dia_2) {
		this.dia_2 = dia_2;
	}
	public Time getHora_1() {
		return hora_1;
	}
	public void setHora_1(Time hora_1) {
		this.hora_1 = hora_1;
	}
	public Time getHora_2() {
		return hora_2;
	}
	public void setHora_2(Time hora_2) {
		this.hora_2 = hora_2;
	}
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	private Time hora_2; 
	private char ativo;  
	private String cpf;
}
