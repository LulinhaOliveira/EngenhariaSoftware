package Teste;

import java.util.ArrayList;
import java.util.List;

import BancoDados.Conexao;
import Dados.TurmaRepositorio;
import Dados.UsuarioRepositorio;

public class Main {

	public static void main(String[] args) {
		//inserir
		ArrayList<Object> myList = new ArrayList<Object>();

		String cpf = "70614897409";
		String nome = "Matheus Leite";
		String email = "matheusantosleite@hotmail.com";
		Character sexo = 'M';
		String telefone = "988540180";
		String password = "456";
		
		myList.add(cpf);
		myList.add(nome);
		myList.add(sexo);
		myList.add(telefone);
		myList.add(email);
		myList.add(password);
		
		UsuarioRepositorio ur = new UsuarioRepositorio();
		Conexao.getInstance().conectar();
		ur.inserirUsuario(myList);
		Conexao.getInstance().desconectar();
		
		
		//encontrar 1
		UsuarioRepositorio usr = new UsuarioRepositorio();
		Conexao.getInstance().conectar();
		usr.encontrarUsuario("70614897409");
		Conexao.getInstance().desconectar();
		
		//encontrar todos
		UsuarioRepositorio user = new UsuarioRepositorio();
		Conexao.getInstance().conectar();
		user.encontrarTodosUsuarios();
		Conexao.getInstance().desconectar();
		
		
	}
}


