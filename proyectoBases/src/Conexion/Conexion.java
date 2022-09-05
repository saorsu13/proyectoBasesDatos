package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/mydb";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";

	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.print("Error");
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.print("conexion ok");
		} catch (SQLException e) {
			System.out.print("Error");
			e.printStackTrace();
		}
		return conexion;
	}

}
