import java.util.List;
import java.util.Scanner;

import dao.ClienteDao;
import dao.ProdutoDao;
import modelos.Cliente;
import modelos.Produto;


public class Main {


	public static void main(String[] args) {


		ProdutoDao produtoDao = new ProdutoDao();
		ClienteDao clienteDao = new ClienteDao();

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


				int opcaoCliente;


				System.out.println("\n===== CLIENTES =====");
				System.out.println("1 - Cadastrar Cliente");
				System.out.println("2 - Listar Clientes");
				System.out.println("3 - Consultar Cliente");
				System.out.println("4 - Alterar Cliente");
				System.out.println("5 - Excluir Cliente");
				System.out.println("0 - Voltar");

				System.out.print("Escolha uma opção: ");

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
							cpf,
							nome,
							email,
							rua,
							numero,
							bairro,
							cep,
							cidade,
							estado
							);



					clienteDao.salvar(cliente);


					System.out.println("Cliente cadastrado com sucesso!");

					break;




				case 2:


					List<Cliente> clientes = clienteDao.consultar();


					for(Cliente c : clientes) {


						System.out.println("----------------");
						System.out.println("ID: " + c.getId());
						System.out.println("Nome: " + c.getNome());
						System.out.println("CPF: " + c.getCpf());
						System.out.println("Email: " + c.getEmail());


					}


					break;





				case 3:


					System.out.print("Digite o ID do cliente: ");

					int id = teclado.nextInt();


					Cliente clienteConsultado = clienteDao.consultar(id);



					if(clienteConsultado != null) {


						System.out.println("----------------");
						System.out.println("ID: " + clienteConsultado.getId());
						System.out.println("Nome: " + clienteConsultado.getNome());
						System.out.println("CPF: " + clienteConsultado.getCpf());
						System.out.println("Email: " + clienteConsultado.getEmail());



					}else {


						System.out.println("Cliente não encontrado!");

					}


					break;





				case 4:


					System.out.print("Digite o ID do cliente: ");

					int idAlterar = teclado.nextInt();



					Cliente clienteAlterar = clienteDao.consultar(idAlterar);



					if(clienteAlterar != null) {


						teclado.nextLine();


						System.out.print("Novo nome: ");

						String novoNome = teclado.nextLine();


						System.out.print("Novo email: ");

						String novoEmail = teclado.nextLine();



						clienteAlterar.setNome(novoNome);

						clienteAlterar.setEmail(novoEmail);



						clienteDao.alterar(clienteAlterar);



						System.out.println("Cliente alterado com sucesso!");



					}else {


						System.out.println("Cliente não encontrado!");

					}



					break;






				case 5:


					System.out.print("Digite o ID do cliente: ");

					int idExcluir = teclado.nextInt();



					Cliente clienteExcluir = clienteDao.consultar(idExcluir);



					if(clienteExcluir != null) {


						clienteDao.deletar(idExcluir);


						System.out.println("Cliente excluído com sucesso!");


					}else {


						System.out.println("Cliente não encontrado!");

					}


					break;




				case 0:

					System.out.println("Voltando...");

					break;



				default:

					System.out.println("Opção inválida!");

				}


				break;





			case 3:

				System.out.println("Menu de Pedidos");

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