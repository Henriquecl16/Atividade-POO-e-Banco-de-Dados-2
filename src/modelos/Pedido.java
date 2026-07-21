package modelos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int id;
	private Cliente cliente;
	private String data;
	private String status;
	private List<Produto> produtos;


	public Pedido() {

		produtos = new ArrayList<Produto>();

	}



	public Pedido(Cliente cliente, String data, String status) {

		this.cliente = cliente;
		this.data = data;
		this.status = status;
		this.produtos = new ArrayList<Produto>();

	}



	public Pedido(int id, Cliente cliente, String data, String status) {

		this.id = id;
		this.cliente = cliente;
		this.data = data;
		this.status = status;
		this.produtos = new ArrayList<Produto>();

	}



	public void adicionarNoCarrinho(Produto produto) {

		produtos.add(produto);

	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}



	public List<Produto> getProdutos() {

		return produtos;

	}



	public void setProdutos(List<Produto> produtos) {

		this.produtos = produtos;

	}


}