package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICRUD;
import modelos.Cliente;
import utils.ConectaDB;


public class ClienteDao implements ICRUD<Cliente> {


	@Override
	public Cliente salvar(Cliente cliente) {

		String sql = "insert into tb_clientes(cpf, nome, email, rua, numero, bairro, cep, cidade, estado) values(?,?,?,?,?,?,?,?,?)";


		Connection con = ConectaDB.conectar();


		try {

			PreparedStatement stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);


			stm.setString(1, cliente.getCpf());
			stm.setString(2, cliente.getNome());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getRua());
			stm.setInt(5, cliente.getNumero());
			stm.setString(6, cliente.getBairro());
			stm.setString(7, cliente.getCep());
			stm.setString(8, cliente.getCidade());
			stm.setString(9, cliente.getEstado());


			stm.execute();


			ResultSet rs = stm.getGeneratedKeys();


			if(rs.next()) {
				cliente.setId(rs.getInt(1));
			}


			rs.close();
			stm.close();
			con.close();


			return cliente;


		} catch(SQLException e) {

			e.printStackTrace();
			return null;

		}

	}



	@Override
	public void deletar(int id) {

		String sql = "delete from tb_clientes where id = ?";


		Connection con = ConectaDB.conectar();


		try {

			PreparedStatement stm = con.prepareStatement(sql);

			stm.setInt(1, id);

			stm.execute();


			stm.close();
			con.close();


		} catch(SQLException e) {

			e.printStackTrace();

		}

	}



	@Override
	public void alterar(Cliente cliente) {


		String sql = "update tb_clientes set cpf=?, nome=?, email=?, rua=?, numero=?, bairro=?, cep=?, cidade=?, estado=? where id=?";


		Connection con = ConectaDB.conectar();


		try {

			PreparedStatement stm = con.prepareStatement(sql);


			stm.setString(1, cliente.getCpf());
			stm.setString(2, cliente.getNome());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getRua());
			stm.setInt(5, cliente.getNumero());
			stm.setString(6, cliente.getBairro());
			stm.setString(7, cliente.getCep());
			stm.setString(8, cliente.getCidade());
			stm.setString(9, cliente.getEstado());
			stm.setInt(10, cliente.getId());


			stm.execute();


			stm.close();
			con.close();


		} catch(SQLException e) {

			e.printStackTrace();

		}

	}



	@Override
	public Cliente consultar(int id) {


		Cliente cliente = null;


		Connection con = ConectaDB.conectar();


		try {


			PreparedStatement stm = con.prepareStatement(
					"select * from tb_clientes where id = ?"
					);


			stm.setInt(1, id);


			ResultSet rs = stm.executeQuery();



			if(rs.next()) {

				cliente = new Cliente(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
						);

			}


			rs.close();
			stm.close();
			con.close();


		} catch(SQLException e) {

			e.printStackTrace();

		}


		return cliente;

	}



	@Override
	public List<Cliente> consultar() {


		List<Cliente> clientes = new ArrayList<Cliente>();


		Connection con = ConectaDB.conectar();


		try {


			PreparedStatement stm = con.prepareStatement(
					"select * from tb_clientes"
					);


			ResultSet rs = stm.executeQuery();



			while(rs.next()) {


				Cliente cliente = new Cliente(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
						);


				clientes.add(cliente);

			}


			rs.close();
			stm.close();
			con.close();


		} catch(SQLException e) {

			e.printStackTrace();

		}


		return clientes;

	}

}