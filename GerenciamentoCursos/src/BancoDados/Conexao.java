package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	public static Conexao instance;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public static Conexao getInstance() {
		if(Conexao.instance == null) {
			return Conexao.instance = new Conexao();
		}
		return Conexao.instance;
	}
	public void conectar() {
		String servidor = "jdbc:mysql://remotemysql.com:3306/DYvQEcmfPu";
		String usuario = "DYvQEcmfPu";
		String senha = "nWuFooVwBz";
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch(Exception e) {
			System.out.println("Erro" + e.getMessage());
		}

	}
	
	public void desconectar() {
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	public boolean conectado() {
		if(this.connection != null)
			return true;
		else
			return false;
	}
	
	public int executaSQL(String sql) {
		try {
			Conexao.getInstance().getStatement().executeUpdate(sql);
		}catch(Exception e) {
			System.out.println("Error" + e.getMessage());
			return 500; //erro interno do sistema
		}
		return 200; //sucess
	}
	
	public int buscarSQL(String sql) {
		try {
			Conexao.getInstance().setResultset(Conexao.getInstance().getStatement().executeQuery(sql));
			Conexao.getInstance().setStatement(Conexao.getInstance().getConnection().createStatement());
		
		}catch(Exception e) {
			System.out.println("Error " + e.getMessage());
			return 500; //return 500 = erro do sistema
		}
		return 200; //return 200 = sucesso
	}
	
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	public ResultSet getResultset() {
		return resultset;
	}
	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}


}
