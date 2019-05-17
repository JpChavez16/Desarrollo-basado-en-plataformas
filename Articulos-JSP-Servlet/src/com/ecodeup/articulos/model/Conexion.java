package com.ecodeup.articulos.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
 
public class Conexion{
    private Connection jdbcConnection;
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/javaweb_crud";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "180500master";
    
 
	public void conectar() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
	
		public Connection getJdbcConnection() {
		return jdbcConnection;
		}  
     
    public void desconectar() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
 

 
}