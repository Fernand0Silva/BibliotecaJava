package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Livro;



public class LivroDao {
	
	//Crud
	
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Livro livro) {
		String sql = "insert into pessoa(nome,data,preco) values (Volta ao Mundo,1960,59)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, livro.getNome());
			ps.setDate(2, (Date) livro.getData());
			ps.setDouble(3, livro.getPreco());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

}
