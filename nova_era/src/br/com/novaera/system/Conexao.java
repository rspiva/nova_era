package br.com.novaera.system;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

import java.sql.*;

public class Conexao {
	
    private static final String STR_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE = "admcoml2";
    private static final String IP = "localhost";
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "123";
	
	public DBCollection getConexaoA(String c) throws UnknownHostException, MongoException{	
		Mongo m = new Mongo( "localhost" , 27017 );
		
		
		//String host = "mongodb-mongodbconnection.jelastic.";
		String dbname = "VNP_A";
        //String user = "admin";
        //String password = "DAyut5ZYMq";
        
        DB db = m.getDB( dbname );
        /*
        if (db.authenticate(user, password.toCharArray())) {
            System.out.println("Connected!");
        } else {
            System.out.println("Connection failed");
        }
        */

        
		db.requestStart();
		DBCollection collection = db.getCollection(c);
		
		return collection;
		
	}
	
	public static Connection getConexao() throws JpivaException {
        Connection conn = null;
        try {
                Class.forName(STR_DRIVER);
                conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
                System.out.println("[ConnectionManager]: Obtendo conexao");
                return conn;
        } catch (ClassNotFoundException e) {
                throw new JpivaException("Driver nao encontrado", e);
        } catch (SQLException e) {
                throw new JpivaException("Erro ao obter a conexao", e);
        }
	}
	
	public static void closeAll(Connection conn) {
	        try {
	                if (conn != null) {
	                        conn.close();
	                }
	        } catch (Exception e) {
	                System.out.println("---> Nao foi possivel fechar a conexao com o banco");
	                System.out.println("---> Detalhamento do erro: ");
	                e.printStackTrace();
	        }
	}
	
	public static void closeAll(Connection conn, Statement stmt) {
	        try {
	                if (stmt != null) {
	                        stmt.close();
	                }
	                closeAll(conn);
	        } catch (Exception e) {
	                System.out.println("---> Nao foi possivel fechar a conexao com o banco");
	                System.out.println("---> Detalhamento do erro: ");
	                e.printStackTrace();
	        }
	}
	
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs ) {
	        try {
	                if (rs != null) {
	                        rs.close();
	                }
	                closeAll(conn, stmt);
	        } catch (Exception e) {
	                System.out.println("---> Nao foi possivel fechar a conexao com o banco");
	                System.out.println("---> Detalhamento do erro: ");
	                e.printStackTrace();
	        }
	}

}
