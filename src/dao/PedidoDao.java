package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICRUD;
import modelos.Cliente;
import modelos.Pedido;
import utils.ConectaDB;


public class PedidoDao implements ICRUD<Pedido> {


	@Override
	public Pedido salvar(Pedido pedido) {


		String sql = "insert into tb_pedidos(cliente, data, status) values(?,?,?)";


		Connection con = ConectaDB.conectar();


		try {


			PreparedStatement stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);


			stm.setInt(1, pedido.getCliente().getId());
			stm.setString(2, pedido.getData());
			stm.setString(3, pedido.getStatus());


			stm.execute();


			ResultSet rs = stm.getGeneratedKeys();


			if(rs.next()) {

				pedido.setId(rs.getInt(1));

			}


			rs.close();
			stm.close();
			con.close();


			return pedido;



		} catch(SQLException e) {

			e.printStackTrace();
			return null;

		}


	}




	public void finalizarPedido(Pedido pedido) {


		pedido.finalizarPedido();

		alterar(pedido);


	}




	@Override
	public void deletar(int id) {


		String sql = "delete from tb_pedidos where id = ?";


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
	public void alterar(Pedido pedido) {


		String sql = "update tb_pedidos set cliente=?, data=?, status=? where id=?";


		Connection con = ConectaDB.conectar();



		try {


			PreparedStatement stm = con.prepareStatement(sql);


			stm.setInt(1, pedido.getCliente().getId());
			stm.setString(2, pedido.getData());
			stm.setString(3, pedido.getStatus());
			stm.setInt(4, pedido.getId());


			stm.execute();


			stm.close();
			con.close();



		} catch(SQLException e) {


			e.printStackTrace();


		}


	}





	@Override
	public Pedido consultar(int id) {


		Pedido pedido = null;


		Connection con = ConectaDB.conectar();



		try {


			PreparedStatement stm = con.prepareStatement(
					"select * from tb_pedidos where id = ?"
					);



			stm.setInt(1, id);



			ResultSet rs = stm.executeQuery();



			if(rs.next()) {


				Cliente cliente = new Cliente();

				cliente.setId(rs.getInt(2));



				pedido = new Pedido(
						rs.getInt(1),
						cliente,
						rs.getString(3),
						rs.getString(4)
						);


			}



			rs.close();
			stm.close();
			con.close();



		} catch(SQLException e) {


			e.printStackTrace();


		}



		return pedido;


	}





	@Override
	public List<Pedido> consultar() {


		List<Pedido> pedidos = new ArrayList<Pedido>();


		Connection con = ConectaDB.conectar();



		try {


			PreparedStatement stm = con.prepareStatement(
					"select * from tb_pedidos"
					);



			ResultSet rs = stm.executeQuery();



			while(rs.next()) {


				Cliente cliente = new Cliente();

				cliente.setId(rs.getInt(2));



				Pedido pedido = new Pedido(
						rs.getInt(1),
						cliente,
						rs.getString(3),
						rs.getString(4)
						);



				pedidos.add(pedido);


			}



			rs.close();
			stm.close();
			con.close();



		} catch(SQLException e) {


			e.printStackTrace();


		}



		return pedidos;


	}


}