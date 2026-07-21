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


			System.out.println("\n===== MENU =====");
			System.out.println("1 - Produtos");
			System.out.println("2 - Clientes");
			System.out.println("3 - Pedidos");
			System.out.println("0 - Sair");

			System.out.print("Escolha uma opção: ");

			opcao = teclado.nextInt();



			switch(opcao) {



			case 1:

				System.out.println("Menu de Produtos");

				break;





			case 2:

				System.out.println("Menu de Clientes");

				break;





			case 3:


				int opcaoPedido;



				System.out.println("\n===== PEDIDOS =====");
				System.out.println("1 - Criar Pedido");
				System.out.println("2 - Listar Pedidos");
				System.out.println("3 - Finalizar Pedido");
				System.out.println("0 - Voltar");

				System.out.print("Escolha uma opção: ");

				opcaoPedido = teclado.nextInt();





				switch(opcaoPedido) {



				case 1:


					System.out.print("Digite o ID do cliente: ");

					int idCliente = teclado.nextInt();



					Cliente cliente = clienteDao.consultar(idCliente);



					if(cliente != null) {


						teclado.nextLine();


						System.out.print("Data do pedido: ");

						String data = teclado.nextLine();



						Pedido pedido = new Pedido(
								cliente,
								data,
								"Em aberto"
								);



						pedidoDao.salvar(pedido);



						System.out.println("Pedido criado com sucesso!");



					}else {


						System.out.println("Cliente não encontrado!");

					}



					break;





				case 2:


					List<Pedido> pedidos = pedidoDao.consultar();



					for(Pedido p : pedidos) {


						System.out.println("----------------");

						System.out.println("ID: " + p.getId());
						System.out.println("Cliente: " + p.getCliente().getId());
						System.out.println("Data: " + p.getData());
						System.out.println("Status: " + p.getStatus());

					}



					break;





				case 3:


					System.out.print("Digite o ID do pedido: ");

					int idPedido = teclado.nextInt();



					Pedido pedidoFinalizar = pedidoDao.consultar(idPedido);



					if(pedidoFinalizar != null) {


						pedidoDao.finalizarPedido(pedidoFinalizar);


						System.out.println("Pedido finalizado com sucesso!");



					}else {


						System.out.println("Pedido não encontrado!");

					}



					break;





				case 0:

					System.out.println("Voltando...");

					break;




				default:

					System.out.println("Opção inválida!");

				}



				break;





			case 0:

				System.out.println("Encerrando sistema...");

				break;





			default:

				System.out.println("Opção inválida!");

			}



		}while(opcao != 0);



		teclado.close();


	}


}