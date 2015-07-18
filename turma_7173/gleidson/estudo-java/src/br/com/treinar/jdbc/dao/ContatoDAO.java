package br.com.treinar.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.treinar.jdbc.modelo.Contato;
import br.com.treinar.jdbc.util.ConnectionFactory;

public class ContatoDAO {

	// a conex�o com o banco de dados
	private Connection con;

	public ContatoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adicionar(Contato contato) {
		String sql = "insert into contatos "
				+ "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = con.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTime()));

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.con
					.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			Contato contato = null;
			while (rs.next()) {
				// criando o objeto Contato
				contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando a data atrav�s do Calendar
				java.util.Date data = new java.util.Date(rs.getDate("dataNascimento").getTime());
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
