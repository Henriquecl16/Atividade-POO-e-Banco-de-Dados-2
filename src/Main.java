import java.util.List;
import java.util.Scanner;

import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import modelos.Cliente;
import modelos.Pedido;
import modelos.Produto;


public class Main {

	public static void main(String[] args) {


		ProdutoDao produtoDao = new ProdutoDao();
		ClienteDao clienteDao = new ClienteDao();
		PedidoDao pedidoDao = new PedidoDao();


		Scanner teclado = new Scanner(System.in);


		int opcao = 0;



		do {


			System.out.println("\n===== MENU PRINCIPAL =====");
			System.out.println("1 - Produtos");
			System.out.println("2 - Clientes");
			System.out.println("3 - Pedidos");
			System.out.println("0 - Sair");

			System.out.print("Escolha: ");

			opcao = teclado.nextInt();



			switch(opcao) {



			// ================= PRODUTOS =================

			case 1:


				int opcaoProduto;


				System.out.println("\n===== PRODUTOS =====");
				System.out.println("1 - Cadastrar Produto");
				System.out.println("2 - Listar Produtos");
				System.out.println("3 - Consultar Produto");
				System.out.println("4 - Alterar Produto");
				System.out.println("5 - Excluir Produto");
				System.out.println("0 - Voltar");


				System.out.print("Escolha: ");

				opcaoProduto = teclado.nextInt();



				switch(opcaoProduto) {


				case 1:

					teclado.nextLine();


					System.out.print("Descrição: ");
					String descricao = teclado.nextLine();


					System.out.print("Preço: ");
					double preco = teclado.nextDouble();


					System.out.print("Estoque: ");
					int estoque = teclado.nextInt();



					Produto produto = new Produto(
							descricao,
							preco,
							estoque
							);



					produtoDao.salvar(produto);


					System.out.println("Produto cadastrado!");

					break;



				case 2:


					List<Produto> produtos = produtoDao.consultar();


					for(Produto p : produtos) {

						System.out.println("----------------");
						System.out.println("ID: " + p.getId());
						System.out.println("Descrição: " + p.getDescricao());
						System.out.println("Preço: " + p.getPreco());
						System.out.println("Estoque: " + p.getEstoque());

					}


					break;



				case 3:


					System.out.print("ID do produto: ");

					int idProduto = teclado.nextInt();


					Produto produtoBusca = produtoDao.consultar(idProduto);



					if(produtoBusca != null) {

						System.out.println(produtoBusca.getDescricao());
						System.out.println(produtoBusca.getPreco());
						System.out.println(produtoBusca.getEstoque());

					}else {

						System.out.println("Produto não encontrado!");

					}


					break;



				case 4:


					System.out.print("ID do produto: ");

					int idAlterar = teclado.nextInt();



					Produto produtoAlterar = produtoDao.consultar(idAlterar);



					if(produtoAlterar != null) {


						teclado.nextLine();


						System.out.print("Nova descrição: ");
						produtoAlterar.setDescricao(teclado.nextLine());


						System.out.print("Novo preço: ");
						produtoAlterar.setPreco(teclado.nextDouble());


						System.out.print("Novo estoque: ");
						produtoAlterar.setEstoque(teclado.nextInt());


						produtoDao.alterar(produtoAlterar);


						System.out.println("Produto alterado!");

					}


					break;



				case 5:


					System.out.print("ID do produto: ");

					produtoDao.deletar(teclado.nextInt());


					System.out.println("Produto excluído!");

					break;



				}


				break;





			// ================= CLIENTES =================


			case 2:


				int opcaoCliente;


				System.out.println("\n===== CLIENTES =====");
				System.out.println("1 - Cadastrar Cliente");
				System.out.println("2 - Listar Clientes");
				System.out.println("3 - Consultar Cliente");
				System.out.println("4 - Alterar Cliente");
				System.out.println("5 - Excluir Cliente");
				System.out.println("0 - Voltar");


				System.out.print("Escolha: ");

				opcaoCliente = teclado.nextInt();



				switch(opcaoCliente) {



				case 1:


					teclado.nextLine();


					System.out.print("CPF: ");
					String cpf = teclado.nextLine();


					System.out.print("Nome: ");
					String nome = teclado.nextLine();


					System.out.print("Email: ");
					String email = teclado.nextLine();


					System.out.print("Rua: ");
					String rua = teclado.nextLine();


					System.out.print("Número: ");
					int numero = teclado.nextInt();


					teclado.nextLine();


					System.out.print("Bairro: ");
					String bairro = teclado.nextLine();


					System.out.print("CEP: ");
					String cep = teclado.nextLine();


					System.out.print("Cidade: ");
					String cidade = teclado.nextLine();


					System.out.print("Estado: ");
					String estado = teclado.nextLine();



					Cliente cliente = new Cliente(
							cpf,nome,email,rua,
							numero,bairro,cep,
							cidade,estado
							);



					clienteDao.salvar(cliente);


					System.out.println("Cliente cadastrado!");

					break;



				case 2:


					List<Cliente> clientes = clienteDao.consultar();


					for(Cliente c : clientes) {

						System.out.println("----------------");
						System.out.println("ID: " + c.getId());
						System.out.println("Nome: " + c.getNome());

					}


					break;



				case 3:


					System.out.print("ID Cliente: ");

					Cliente c = clienteDao.consultar(teclado.nextInt());


					if(c != null) {

						System.out.println(c.getNome());
						System.out.println(c.getEmail());

					}


					break;



				case 4:


					System.out.println("Alteração de cliente");

					break;



				case 5:


					System.out.print("ID Cliente: ");

					clienteDao.deletar(teclado.nextInt());


					System.out.println("Cliente excluído!");

					break;


				}


				break;






			// ================= PEDIDOS =================


			case 3:


				int opcaoPedido;


				System.out.println("\n===== PEDIDOS =====");
				System.out.println("1 - Criar Pedido");
				System.out.println("2 - Listar Pedidos");
				System.out.println("3 - Finalizar Pedido");
				System.out.println("0 - Voltar");


				System.out.print("Escolha: ");

				opcaoPedido = teclado.nextInt();



				switch(opcaoPedido) {



				case 1:


					System.out.print("ID Cliente: ");

					Cliente clientePedido =
							clienteDao.consultar(teclado.nextInt());



					if(clientePedido != null) {


						teclado.nextLine();


						System.out.print("Data: ");

						String data = teclado.nextLine();



						Pedido pedido = new Pedido(
								clientePedido,
								data,
								"Em aberto"
								);



						pedidoDao.salvar(pedido);


						System.out.println("Pedido criado!");

					}


					break;



				case 2:


					List<Pedido> pedidos = pedidoDao.consultar();


					for(Pedido p : pedidos) {

						System.out.println("----------------");
						System.out.println("ID: " + p.getId());
						System.out.println("Status: " + p.getStatus());

					}


					break;



				case 3:


					System.out.print("ID Pedido: ");

					Pedido pedido =
							pedidoDao.consultar(teclado.nextInt());



					if(pedido != null) {


						pedidoDao.finalizarPedido(pedido);


						System.out.println("Pedido finalizado!");

					}


					break;

				}


				break;




			case 0:

				System.out.println("Encerrando...");

				break;



			default:

				System.out.println("Opção inválida!");

			}



		}while(opcao != 0);



		teclado.close();

	}

}