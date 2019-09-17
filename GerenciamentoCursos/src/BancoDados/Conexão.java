package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexão {
	public static Conexão instance;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public static Conexão getInstance() {
		if(Conexão.instance == null) {
			return Conexão.instance = new Conexão();
		}
		return Conexão.instance;
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
