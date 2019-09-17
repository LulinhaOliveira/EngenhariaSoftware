package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conex�o {
	public static Conex�o instance;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public static Conex�o getInstance() {
		if(Conex�o.instance == null) {
			return Conex�o.instance = new Conex�o();
		}
		return Conex�o.instance;
	}
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/gerenciarcursos";
		String usuario = "root";
		String senha = "lulinha628";
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
