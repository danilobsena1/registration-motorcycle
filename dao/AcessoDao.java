package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.Motos;

public class AcessoDao {
	private DataSource datasource;

	public AcessoDao(DataSource datasource) {
		this.datasource = datasource;
	}

	public void adicionarMoto(Motos moto) {
		try {
			String SQL = "insert into Motos(marca, modelo, valor, ano) values (?, ?, ?, ?)";
			PreparedStatement ps = datasource.obterConexao().prepareStatement(SQL);
			ps.setString(1, moto.getMarca());
			ps.setString(2, moto.getModelo());
			ps.setDouble(3, moto.getValor());
			ps.setInt(4, moto.getAno());

			ps.execute(); // preparando a SQL para execução e inserção no banco.

			ps.close();

		} catch (SQLException e) {
			System.err.println("Erro de conexão" + e.getMessage());
		} catch (Exception e) {
			System.err.println("Erro de codificação" + e.getMessage());
		}
	}

	// Exibindo as informações na tabela

	public Collection<Motos> exibirMotos(){
		
		Collection<Motos> listaMotos = new ArrayList<>();
		
		ResultSet rs; // onde ficarão armazenados os resultados.

		try {
			

			String SQL = "select * from Motos";
			PreparedStatement ps = datasource.obterConexao().prepareStatement(SQL);
			rs = ps.executeQuery(); // Responsavel por fazer as consultas no banco.
			
			while (rs.next()) {
				
				Motos moto = new Motos();
				
				moto.setMarca(rs.getString("marca"));
				moto.setModelo(rs.getString("modelo"));
				moto.setValor(rs.getDouble("valor"));
				moto.setAno(rs.getInt("ano"));
				
				listaMotos.add(moto);
				
			}
			ps.close();

		} catch (SQLException e) {
			System.err.println("Erro de conexão" + e.getMessage());
		} catch (Exception e) {
			System.err.println("ERRO 404!" + e.getMessage());
		}
		return listaMotos;

	}
}
