package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private Connection conexao; // Obtendo a conexao.
	
	public DataSource(){
		try {
			
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojaMoto", "root", "");
						
			System.out.println("Conectado!");
	}catch (SQLException e){
		System.err.println("Erro de conexão"+e.getMessage());
	}catch (Exception e){
		System.err.println("Entre em contato com o administrador do sistema"+e.getMessage());
	}
 }
	//METODOS de verificação
	
	public Connection obterConexao(){
		return this.conexao;
	}
	public void fecharConexao(){
		try{
			conexao.close();
			System.err.println("Desconectado");
		}catch(SQLException e){
			System.err.println("Erro de conexão" + e.getMessage());
		}catch (Exception e) {
			System.err.println("Erro de codificação"+ e.getMessage());
		}
		
	}
}
